package com.all;

public class Profile2 {
    public String firstname;
    public String lastname;
    public String address;
    public String email;
    public String phone;
    public String facebook;
    public String linkedin;
    public String username;
    public String about;
    public String work;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getUsername() {
        return username;
    }

    public String getAbout() {
        return about;
    }

    public String getWork() {
        return work;
    }

    public Profile2(String firstname, String lastname, String address, String email, String phone, String facebook, String linkedin, String username, String about, String work) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.username = username;
        this.about = about;
        this.work = work;
    }
}