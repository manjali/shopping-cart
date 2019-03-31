package com.assessment.skuservice.service.impl;

import com.assessment.skuservice.entity.*;
import com.assessment.skuservice.exception.InsufficientNumberException;
import com.assessment.skuservice.repository.OrderCustomerRepository;
import com.assessment.skuservice.repository.OrderRepository;
import com.assessment.skuservice.repository.SkuRepository;
import com.assessment.skuservice.service.OrderService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Value("${service.cutomersearch.serviceId}")
   private String customerService;

    @Autowired
    private OrderCustomerRepository customerProductRelation;

    @Autowired
    private SkuRepository skuRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Transactional(rollbackOn = {InsufficientNumberException.class,Exception.class})
    public String addOrder(OrderInfo order) throws InsufficientNumberException, Exception{

            boolean addCustomer = false;
            boolean customerExists = checkCustomerExists(order.getCustomerId());
            if (!customerExists) {
                addCustomer = addNewCustomer(order.getCustomerId());
            }

            if (customerExists || addCustomer) {
                boolean areProductsAvailable = checkProductAvailbility(order.getStockunits());
                if(areProductsAvailable) {
                    customerProductRelation.save(new CustomerProductRelation(order.getCustomerId(), order.getOrderId()));
                    for (StockUnit sts : order.getStockunits()) {

                        ProductsPerOrder productsPerOrder = new ProductsPerOrder(new CombinedKey(order.getOrderId(), sts.getId()), sts.getNumberOfItems());
                        orderRepository.save(productsPerOrder);
                        return "Success";
                    }
                }
        }
        return "Failure";

    }

    public boolean checkProductAvailbility(List<StockUnit> orderProducts) throws InsufficientNumberException {
        if (orderProducts != null) {
            for (StockUnit st : orderProducts) {
                 int productNumber = (skuRepository.getProductNumber(st.getId())).intValue();
                    if (productNumber > 0 && productNumber >= st.getNumberOfItems()) {
                        st.setNumberOfItems(productNumber - st.getNumberOfItems());
                        skuRepository.save(st);
                    } else {
                        throw new InsufficientNumberException();
                    }
                }
            return true;
        }
        else {
            return false;
        }
    }

    /*
    Can use FeignCLient here. But ran into some dependedency issues here.
    Can do: modify with FeignClient
     */
    public boolean checkCustomerExists(String customerId)
    {
        Application customerApplication = eurekaClient.getApplication(customerService);
        InstanceInfo instanceInfo = customerApplication.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "customer/view?customerId=" + customerId;
        System.out.println("URL" + url);        ;
        CustomerInfo customer = restTemplate.getForObject(url, CustomerInfo.class);
        /*ResponseEntity customer = restTemplate.getForObject(url, ResponseEntity.class);
        System.out.println("RESPONSE " + customer);
        if(customer.getStatusCode().equals(HttpStatus.OK)){
            return true;
        }*/
        if(customer!=null){
            return true;
        }
        else
            return false;
    }

    //Add code in customer service to add customer with Id
    public boolean addNewCustomer(String custId){
        Application customerApplication = eurekaClient.getApplication(customerService);
        InstanceInfo instanceInfo = customerApplication.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "customer/addCustomerwithId";
        System.out.println("URL" + url);
        HttpEntity<String> request = new HttpEntity<>(custId);
        ResponseEntity<Integer> response = restTemplate.exchange(url, HttpMethod.POST, request, Integer.class);
        System.out.println("RESPONSE " + response);
        if(response.getStatusCode().equals(HttpStatus.OK)){
            return true;
        }
        else
            return false;
    }

    @Override
    public OrderInfo viewOrder(String orderId) {
        return null;
    }
}
