package com.scenariobased.medwarehouse;

public class MedWarehouseMain {

    public static void main(String[] args) {

        Medicine[] medicines = {
            new Medicine("Paracetamol", 15),
            new Medicine("Insulin", 5),
            new Medicine("Antibiotic", 30),
            new Medicine("Vaccine", 10),
            new Medicine("Cough Syrup", 5)
        };

        MergeSortUtil.mergeSort(medicines, 0, medicines.length - 1);

        System.out.println("Medicine Expiry Priority List:");
        for (Medicine m : medicines) {
            System.out.println(m.name + " -> Expires in " + m.expiryDays + " days");
        }
    }
}
