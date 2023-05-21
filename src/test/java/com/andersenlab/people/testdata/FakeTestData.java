package com.andersenlab.people.testdata;

import com.github.javafaker.Faker;

import java.io.File;

public class FakeTestData {
    public Faker faker = new Faker();
    public String jobName = faker.job().position();
    public String name = faker.name().firstName();
    public String email = faker.cat().breed();
    public String comment = faker.harryPotter().spell();
    public File file = new File("testfiles/resume.docx");
    public String fileName = file.getPath();
}
