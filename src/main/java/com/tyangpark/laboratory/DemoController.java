package com.tyangpark.laboratory;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class DemoController {

    @NonNull
    private final CustomerRepository customerRepository;
    @NonNull
    private final ItemRepository itemRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last) {
        Set<Item> itemSet = new HashSet<>();
        Item item1 = new Item();
        item1.setName("test1");

        Item item2 = new Item();
        item2.setName("test2");

        itemSet.add(item1);
        itemSet.add(item2);
        itemRepository.saveAll(itemSet);

        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customer.setItems(itemSet);
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }
}
