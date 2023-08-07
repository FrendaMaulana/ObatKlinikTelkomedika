package com.apotek.crudobat.service;

import com.apotek.crudobat.model.Obat;
import com.apotek.crudobat.model.ObatDTO;
import com.apotek.crudobat.model.ObatHistory;
import com.apotek.crudobat.repository.ObatHistoryRepository;
import com.apotek.crudobat.repository.ObatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObatService {

    private final ObatRepository obatRepository;
    private final ModelMapper modelMapper;
    private final ObatHistoryRepository obatHistoryRepository;

    @Autowired
    public ObatService(ModelMapper modelMapper,
                       ObatRepository obatRepository,
                       ObatHistoryRepository obatHistoryRepository) {

        this.obatRepository = obatRepository;
        this.modelMapper = modelMapper;
        this.obatHistoryRepository = obatHistoryRepository;
    }

    public List<ObatDTO> getAllObats() {
        List<Obat> obats = obatRepository.findAll();
        return obats.stream()
                .map(obat -> modelMapper.map(obat, ObatDTO.class))
                .collect(Collectors.toList());
    }

    public ObatDTO getObatById(Long id) {
        Obat obat = obatRepository.findById(id).orElse(null);
        if (obat != null) {
            return modelMapper.map(obat, ObatDTO.class);
        }
        return null;
    }

    public ObatDTO createObat(ObatDTO obatDTO) {
        Obat obat = modelMapper.map(obatDTO, Obat.class);
        obat.setCreateAt(new Date());
        Obat savedObat = obatRepository.save(obat);
        return modelMapper.map(savedObat, ObatDTO.class);
    }

    public ObatDTO updateObat(Long id, ObatDTO obatDTO) {
        Obat obat = obatRepository.findById(id).orElse(null);

        ObatHistory obatHistory = new ObatHistory();

        obatHistory.setId_obat(obat.getId());
        obatHistory.setNama_obat(obat.getNama_obat());
        obatHistory.setKategori(obat.getKategori());
        obatHistory.setStok(obat.getStok());
        obatHistory.setHarga(obat.getHarga());
        obatHistory.setSupplier(obat.getSupplier());
        obatHistory.setCreateAt(new Date());

        obatHistoryRepository.save(obatHistory);

        if (obat != null) {
//            modelMapper.map(transactionDTO, transaction);
            if(obatDTO.getNama_obat() != null) {
                obat.setNama_obat(obatDTO.getNama_obat());
            } if(obatDTO.getKategori() != null) {
                obat.setKategori(obatDTO.getKategori());
            } if(obatDTO.getStok() != null) {
                obat.setStok(obatDTO.getStok());
            } if(obatDTO.getHarga() != null) {
                obat.setHarga(obatDTO.getHarga());
            } if(obatDTO.getSupplier() != null) {
                obat.setSupplier(obatDTO.getSupplier());
            } obat.setUpdateAt(new Date());

            Obat savedObat = obatRepository.save(obat);
            return modelMapper.map(savedObat, ObatDTO.class);
        }
        return null;
    }

    public void deleteObat(Long id) {
        obatRepository.deleteById(id);
    }

    public List<ObatHistory> getAllObatsHistory() {
        return obatHistoryRepository.findAll();
    }

    public ObatHistory getObatHistoryById(Long id) {
       return obatHistoryRepository.findById(id).orElse(null);
    }


}
