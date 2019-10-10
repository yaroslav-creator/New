package com.javarush.task.task28.task2810.vo;

import java.util.Objects;

/**
 * Этот класс будет хранить данные о вакансии.
 * */
public class Vacancy {
    private String title;         //Название,
    private String salary;        //зарплата,
    private String city;          //город,
    private String companyName;   //название компании, на котором вакансия найдена,
    private String siteName;      //название сайта,
    private String url;           //ссылка на вакансию.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacancy)) return false;
        Vacancy vacancy = (Vacancy) o;
        return getTitle().equals(vacancy.getTitle()) &&
                getSalary().equals(vacancy.getSalary()) &&
                getCity().equals(vacancy.getCity()) &&
                getCompanyName().equals(vacancy.getCompanyName()) &&
                getSiteName().equals(vacancy.getSiteName()) &&
                getUrl().equals(vacancy.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSalary(), getCity(), getCompanyName(), getSiteName(), getUrl());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
