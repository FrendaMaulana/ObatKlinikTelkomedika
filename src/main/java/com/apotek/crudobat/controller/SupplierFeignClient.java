//package com.apotek.crudobat.controller;
//
//import com.apotek.crudobat.model.SupplierDTO;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@FeignClient(name = "supplier")
//public interface SupplierFeignClient {
//    @GetMapping("/supplier/all")
//    List<SupplierDTO> getAllSupplier();
//
//    @GetMapping("/supplier/{id}")
//    SupplierDTO getSupplierById(@PathVariable Integer id);
//}