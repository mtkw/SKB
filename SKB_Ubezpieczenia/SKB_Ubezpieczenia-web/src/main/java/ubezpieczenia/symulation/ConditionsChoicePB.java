/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.InsuranceConditionsDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class ConditionsChoicePB implements Serializable {

    @Inject
    SymulationControler sc;

    //Elementy manyCheckBox i selelected
    private List<InsuranceConditionsDTO> conditionsListDTO;
    private List<InsuranceConditionsDTO> selectedConditionsListDTO;
    private List<SelectItem> checkBoxListDTO;

    //Przygotowanie i poĹ‚Ä…czenie wszystkich parametrĂłw
    private String idCustomerParam;
    private String idInsuranceParam;
    private List<List<String>> listOfParams;

    public List<List<String>> getListOfParams() {
        return listOfParams;
    }

    public void setListOfParams(List<List<String>> listOfParams) {
        this.listOfParams = listOfParams;
    }

    public String getIdCustomerParam() {
        return idCustomerParam;
    }

    public void setIdCustomerParam(String idCustomerParam) {
        this.idCustomerParam = idCustomerParam;
    }

    public String getIdInsuranceParam() {
        return idInsuranceParam;
    }

    public void setIdInsuranceParam(String idInsuranceParam) {
        this.idInsuranceParam = idInsuranceParam;
    }

    public List<SelectItem> getCheckBoxListDTO() {
        return checkBoxListDTO;
    }

    public void setCheckBoxListDTO(List<SelectItem> checkBoxListDTO) {
        this.checkBoxListDTO = checkBoxListDTO;
    }

    public List<InsuranceConditionsDTO> getConditionsListDTO() {
        return conditionsListDTO;
    }

    public void setConditionsListDTO(List<InsuranceConditionsDTO> conditionsListDTO) {
        this.conditionsListDTO = conditionsListDTO;
    }

    public List<InsuranceConditionsDTO> getSelectedConditionsListDTO() {
        return selectedConditionsListDTO;
    }

    public void setSelectedConditionsListDTO(List<InsuranceConditionsDTO> selectedConditionsListDTO) {
        this.selectedConditionsListDTO = selectedConditionsListDTO;
    }

    public String prepareConditionsactionListener() {

        //Pobranie parametrĂłw ĹĽadania i ustawienie odpowiednich wartoĹ›ci pĂłl prywantych w klasie
        //UmoĹĽliwi to przesĹ‚anie parametrĂłw w odpowiedniej formie do nastepnej klasy juĹĽ bez wykorzystywanie 
        //Requesta
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param1 = (String) requestMap.get("id_customer");
        String param2 = (String) requestMap.get("id_insurance");

        setIdCustomerParam(param1);
        setIdInsuranceParam(param2);

        Integer intparam = Integer.parseInt(getIdInsuranceParam());
        System.out.println("PRZEKAZANe PARAMETRY!!! : " + param1 + " : " + intparam);

        conditionsListDTO = new ArrayList<>(sc.getInsuranceConditionsList(intparam));

        checkBoxListDTO = new ArrayList<>();
        for (InsuranceConditionsDTO row : conditionsListDTO) {
            checkBoxListDTO.add(new SelectItem(row, row.getQuestion(), row.toString()));
            System.out.println("Znalezione zapytanie :" + row.getQuestion() + " toString() :" + row.toString());
        }

        return "conditions";
    }

    public String showConditions() {
        sc.getInsurancePreparedConditionsList();
        return "conditions";
    }
// nie uzywana metoda 
//    public List<List<String>> prepareParams() {
//        listOfParams = new ArrayList<>();
//        List<String> rows = new ArrayList<>();
//
//        for (InsuranceConditionsDTO row : selectedConditionsListDTO) {
//            rows.add(getIdCustomerParam());
//            rows.add(getIdInsuranceParam());
//            rows.add(Integer.toString(row.getId_conditions()));
//        }
//
//        listOfParams.add(rows);
//
//        return listOfParams;
//    }

    public String past() {
        //Przygotowanie Listy id Warunków
        List<Integer> idConditions = new ArrayList<>();
        for (InsuranceConditionsDTO row : selectedConditionsListDTO) {
            idConditions.add(row.getId_conditions());
        }

        //Przygotowanie Listy wszystkich parametrów potrzebnych do zapytania INSERT
        listOfParams = new ArrayList<>();

        for (InsuranceConditionsDTO row : selectedConditionsListDTO) {
            List<String> rows = new ArrayList<>();
            rows.add(getIdCustomerParam());
            rows.add(getIdInsuranceParam());
            rows.add(Integer.toString(row.getId_conditions()));
            listOfParams.add(rows);
        }

        System.out.println("listOfParams SIZE() :" + listOfParams.size());
        for (List l : listOfParams) {
            System.out.println("TEST l: " + l.toString());
        }

        sc.getCustomer(Integer.parseInt(idCustomerParam));
        sc.getInsurance(Integer.parseInt(idInsuranceParam));
        sc.getConditions(idConditions);
        sc.setListAllParams(listOfParams);
        return "summary";
    }
}
