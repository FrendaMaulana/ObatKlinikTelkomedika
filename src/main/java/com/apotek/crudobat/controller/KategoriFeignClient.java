//package com.apotek.crudobat.controller;
//
//import com.apotek.crudobat.model.KategoriDTO;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@FeignClient(name = "kategori" )
//public class KategoriFeignClient {
//
//    @GetMapping("/kategori/all")
//    List<KategoriDTO> getAllKategori();
//
//    @GetMapping("/kategori/{id}")
//    KategoriDTO getKategoriById(@PathVariable Long id);
//
//}
