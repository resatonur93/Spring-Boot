package com.onurk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "users")
public class User {
    @Id
    private String id;
    @Field(name="first_name",type = FieldType.Text)
    private String firstName;
    @Field(name="last_name",type = FieldType.Text)
    private String lastName;
    @Field(name="address",type = FieldType.Text)
    private String address;
    @Field(name="birth_of_date",type = FieldType.Date)
    private Date birthOfDate;
}
