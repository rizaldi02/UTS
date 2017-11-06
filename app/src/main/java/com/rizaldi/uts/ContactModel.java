package com.rizaldi.uts;

/**
 * Created by cipowela on 06/11/17.
 */

public class ContactModel {
    private String nama, email, nomor;

    public ContactModel(String nama, String email, String nomor) {
        this.nama = nama;
        this.email = email;
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNomor() {
        return nomor;
    }
}
