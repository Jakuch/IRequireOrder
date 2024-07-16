package com.jakuch.IRequireOrder.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Hero {

    @Id
    private String id;
    private String name;
    private Attributes attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero hero)) return false;
        return Objects.equals(id, hero.id) && Objects.equals(name, hero.name) && Objects.equals(attributes, hero.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, attributes);
    }

    //    private Hero(HeroBuilder heroBuilder) {
//        this.name = heroBuilder.name;
//        this.attributes = heroBuilder.attributes;
//    }
//
//    public static class HeroBuilder {
//
//        private String name;
//        private Attributes attributes;
//
//        public HeroBuilder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public HeroBuilder attributes(Attributes attributes) {
//            this.attributes = attributes;
//            return this;
//        }
//
//        public Hero build() {
//            return new Hero(this);
//        }
//    }
}
