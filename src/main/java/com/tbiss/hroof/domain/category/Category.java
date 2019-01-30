package com.tbiss.hroof.domain.category;

import com.tbiss.hroof.domain.BaseEntity;
import com.tbiss.hroof.domain.language.Language;
import com.tbiss.hroof.domain.question.Question;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;


    private String description ;


    private String cover ;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "LANGUAGE_ID")
    private Language language;


    @OneToMany(mappedBy = "category" , cascade = CascadeType.MERGE , fetch = FetchType.EAGER)
    private List<Question> questions ;


}
