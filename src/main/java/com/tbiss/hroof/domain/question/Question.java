package com.tbiss.hroof.domain.question;


import com.tbiss.hroof.domain.BaseEntity;
import com.tbiss.hroof.domain.category.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private String name ;

    @OneToMany(mappedBy = "question" , cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    private List<Answer> answers ;

    @Column(columnDefinition = "BOOLEAN default 0")
    private boolean cachable;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category ;

}
