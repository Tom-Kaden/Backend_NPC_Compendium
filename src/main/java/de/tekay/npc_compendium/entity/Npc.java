package de.tekay.npc_compendium.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Arrays;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Npc implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10000000)
    private String image;
    private String name;
    private String race;
    private String belonging;
    private String description;
    private Boolean shopKeeper;
    private String shopLocation;
    private Boolean alive;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "target.required");
    }

    @Override
    public String toString() {
        return "Npc{" +
                "id=" + id +
                ", picture=" + image +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", belonging='" + belonging + '\'' +
                ", description='" + description + '\'' +
                ", shopKeeper=" + shopKeeper +
                ", shopLocation='" + shopLocation + '\'' +
                ", alive=" + alive +
                '}';
    }
}