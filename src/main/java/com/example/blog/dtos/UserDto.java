package com.example.blog.dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.blog.entities.User}
 */
public class UserDto implements Serializable {
    private final Long id;
    private final String lastname;

    public UserDto(Long id, String lastname) {
        this.id = id;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lastname, entity.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lastname = " + lastname + ")";
    }
}