/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import ubezpieczenia.dto.ClientPaymentDTO;
import ubezpieczenia.entity.Payment;

/**
 *
 * @author Mateusz
 */
public class ClientPaymentConverter {
    
    public static void convertEntityToDTO(Payment entity, ClientPaymentDTO dto){
        dto.setId_payment(entity.getIdPayment());
        dto.setTransaction_id(entity.getTransactionId().getIdTransaction());
        dto.setInstallment_1(entity.getInstallment1());
        dto.setInstallment_2(entity.getInstallment2());
        dto.setInstallment_3(entity.getInstallment3());
        dto.setInstallment_4(entity.getInstallment4());
        dto.setInstallment_5(entity.getInstallment5());
        dto.setInstallment_6(entity.getInstallment6());
        dto.setInstallment_7(entity.getInstallment7());
        dto.setInstallment_8(entity.getInstallment8());
        dto.setInstallment_9(entity.getInstallment9());
        dto.setInstallment_10(entity.getInstallment10());
        dto.setInstallment_11(entity.getInstallment11());
        dto.setInstallment_12(entity.getInstallment12());
    }
    
}
