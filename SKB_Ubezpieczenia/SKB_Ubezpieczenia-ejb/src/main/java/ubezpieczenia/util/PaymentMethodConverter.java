/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import ubezpieczenia.dto.PaymentMethodDTO;
import ubezpieczenia.entity.PaymentMethod;

/**
 *
 * @author Mateusz
 */
public class PaymentMethodConverter {
    public static void convertEntityToDTO(PaymentMethod entity, PaymentMethodDTO dto){
         dto.setId_payment_method(entity.getIdPaymentMethod());
         dto.setTransaction_id(entity.getTransactionId().getIdTransaction());
         dto.setPayment_method_id(entity.getPaymentMethodId().getIdPaymentMethodDes());
         dto.setDedline(entity.getPaymentDedline());
         dto.setNumber_of_instalment(entity.getNumberOfInstalment());
         dto.setSingle_instalment(entity.getSingleInstalment());
    }
}
