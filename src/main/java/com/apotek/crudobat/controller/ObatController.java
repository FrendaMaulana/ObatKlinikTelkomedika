package com.apotek.crudobat.controller;

import com.apotek.crudobat.model.KategoriDTO;
import com.apotek.crudobat.model.ObatDTO;
import com.apotek.crudobat.model.ObatHistory;
//import com.apotek.crudobat.model.TransactionDTO;
import com.apotek.crudobat.repository.ObatRepository;
import com.apotek.crudobat.service.ObatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obat")
public class ObatController {

    private final ObatService obatService;

    private final ObatRepository obatRepository;
//    private final TransactionFeignClient transactionFeignClient;
//
//    private final SupplierFeignClient supplierFeignClient;

//    private final  KategoriFeignClient kategoriFeignClient;

    private final ModelMapper modelMapper;

    @Autowired
    public ObatController(ObatService obatService, ObatRepository obatRepository, ModelMapper modelMapper) {
        this.obatService = obatService;
        this.obatRepository = obatRepository;
        this.modelMapper = modelMapper;
    }


//    @GetMapping("/transactions/all")
//    public List<TransactionDTO> getAllTransactions(){
//        List<TransactionDTO> transactions = transactionFeignClient.getAllTransactions();
//        return transactions;
//    }

//    @GetMapping("/kategori/all")
//    public List<KategoriDTO> getAllKategori(){
//        List<KategoriDTO> kategori = kategoriFeignClient.getAllKategori();
//        return kategori;
//    }

//    @GetMapping("/kategori/{id}")
//    public KategoriDTO getKategoriById(@PathVariable Long id) {
//        KategoriDTO kategori = kategoriFeignClient.getKategoriById(id);
//        return kategori;
//    }

    @GetMapping("/history/all")
    public List<ObatHistory> getAllObatsHistory(){
        return obatService.getAllObatsHistory();
    }

//    @GetMapping("/transactions/{id}")
//    public TransactionDTO getTransactionById(@PathVariable Long id) {
//        TransactionDTO transaction = transactionFeignClient.getTransactionById(id);
//        return transaction;
//    }

    @GetMapping("/list")
    public List<ObatDTO> getAllObats() {
        return obatService.getAllObats();
    }

    @PostMapping("/add")
    public ObatDTO createObat(@RequestBody ObatDTO obatDTO) {
        return obatService.createObat(obatDTO);
    }
    @PutMapping("/update/{id}")
    public ObatDTO updateObat(@PathVariable Long id, @RequestBody ObatDTO obatDTO) {
        return obatService.updateObat(id, obatDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteObat(@PathVariable Long id) {
        obatService.deleteObat(id);
    }

    @GetMapping("/{id}")
    public ObatDTO getObatById(@PathVariable Long id) {
        return obatService.getObatById(id);
    }

    @GetMapping("/history/{id}")
    public ObatHistory getObatHistoryById(@PathVariable Long id) {
        return obatService.getObatHistoryById(id);
    }

}
