package com.demo;

import com.demo.protobuf.AddressBookProtos.*;
import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufDemo {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Person xxx = Person.newBuilder()
                .setId(1)
                .setName("XXX")
                .setEmail("xxx@gmail.com")
                .addPhones(Person.Phone.newBuilder()
                        .setNumber("xxxxxxxxx")
                        .setType(Person.PhoneType.HOME))
                .build();

        Person yyy = Person.newBuilder()
                .setId(2)
                .setName("YYY")
                .setEmail("yyy@gmail.com")
                .addPhones(Person.Phone.newBuilder()
                        .setNumber("yyyyyyyyy")
                        .setType(Person.PhoneType.MOBILE))
                .build();

        AddressBook addressBook = AddressBook.newBuilder()
                .addPeople(xxx)
                .addPeople(yyy)
                .build();

        byte[] bytes = addressBook.toByteArray();
        AddressBook parsed = AddressBook.parseFrom(bytes);
        System.out.println(parsed);
        System.out.println(addressBook.equals(parsed));
    }
}
