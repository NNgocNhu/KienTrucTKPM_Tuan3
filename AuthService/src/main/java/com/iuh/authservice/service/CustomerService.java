package com.iuh.authservice.service;


import com.iuh.authservice.model.Customer;
import com.iuh.authservice.model.UserInfo;
import com.iuh.authservice.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CustomerService {

    List<Customer> customerList = null;

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Đảm bảo rằng bạn đã cập nhật PostConstruct để tải danh sách khách hàng từ cơ sở dữ liệu MongoDB (nếu cần).

    public List<Customer> getCustomers() {
        return customerList;
    }

    public Customer getCustomer(String id) {
        // Thay đổi phương thức này để lấy thông tin khách hàng từ cơ sở dữ liệu MongoDB thay vì từ danh sách sản phẩm.
        return customerList.stream()
                .filter(customer -> customer.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Customer with ID " + id + " not found"));
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User added to system";
    }
}

