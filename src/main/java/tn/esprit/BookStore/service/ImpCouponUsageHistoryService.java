package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.BookStore.model.CouponUsageHistory;
import tn.esprit.BookStore.repository.CouponUsageHistoryRepository;

import java.util.List;

@Service
public class ImpCouponUsageHistoryService implements CouponUsageHistoryService {
    @Autowired
    CouponUsageHistoryRepository cUHRepository;

    @Transactional
    @Override
    public boolean add(CouponUsageHistory cuh) {
        try {
            if (cUHRepository.checkIfExist(cuh.getCoupon().getCode(), cuh.getOrder().getId(), cuh.getUsageType()) != null)
                return false;
            cUHRepository.save(cuh);
            return true;
        } catch (Exception ex) {
            //logger
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Transactional
    @Override
    public List<CouponUsageHistory> getHistoryForCoupon(String code) {
        try {
            return cUHRepository.getCouponUsageHistoryByCouponCode(code);

        } catch (Exception ex) {
            //logger
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
