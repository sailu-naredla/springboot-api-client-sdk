package com.sdk.service;

import com.sdk.dto.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

    public Customer get(String url, String apiKey, Long id){
        System.out.println("Starting NON-BLOCKING Controller!");
        url = url+"/"+id;
        Flux<Customer> customerFlux = WebClient.create()
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(Customer.class);

        customerFlux.subscribe(customer -> System.out.println(customer.toString()));
        System.out.println("Exiting NON-BLOCKING Controller!");
        return customerFlux.blockFirst();
    }

    public Customer put(String url, String apiKey, Customer customer){
        return customer;
    }

    public Customer patch(String url, String apiKey, Customer customer){
        return customer;
    }
}
