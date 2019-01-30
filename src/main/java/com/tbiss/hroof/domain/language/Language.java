package com.tbiss.hroof.domain.language;

import com.tbiss.hroof.domain.BaseEntity;
import com.tbiss.hroof.domain.category.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString
public class Language extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    @NotNull
    private String name ;

    @NotNull
    private String code ;


    @Enumerated(EnumType.STRING)
    private LanguageDirection direction ;

    @OneToMany(mappedBy = "language" , cascade = CascadeType.MERGE , fetch = FetchType.EAGER)
    private List<Category> categories ;


    public Language(@NotNull String name, @NotNull String code, LanguageDirection direction) {
        this.name = name;
        this.code = code;
        this.direction = direction;
    }


    public void addCategory(Category category){
        if(this.categories == null){
            this.categories = new ArrayList<>();
        }

        categories.add(category);
    }


    public List<Category> getCategories() {
        return categories == null ? new ArrayList<>(): categories;
    }
}
