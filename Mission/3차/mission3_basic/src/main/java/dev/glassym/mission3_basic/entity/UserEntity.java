package dev.glassym.mission3_basic.entity;

import dev.glassym.mission3_basic.model.BoardDto;
import dev.glassym.mission3_basic.model.UserDto;
import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;

    @OneToMany(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity"
    )
    private List<PostEntity> postEntityList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    public static UserEntityBuilder builder(UserDto dto){
        return new UserEntityBuilder()
                .id(dto.getId())
                .name(dto.getName())
                .password(dto.getPassword());
    }
}
