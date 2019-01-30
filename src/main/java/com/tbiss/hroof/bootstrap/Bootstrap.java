package com.tbiss.hroof.bootstrap;

import com.tbiss.hroof.controller.v1.UserController;
import com.tbiss.hroof.domain.category.Category;
import com.tbiss.hroof.domain.language.Language;
import com.tbiss.hroof.domain.language.LanguageDirection;
import com.tbiss.hroof.domain.question.Answer;
import com.tbiss.hroof.domain.question.Question;
import com.tbiss.hroof.domain.user.Admin;
import com.tbiss.hroof.domain.user.Competitor;
import com.tbiss.hroof.domain.user.User;
import com.tbiss.hroof.repository.category.CategoryRepository;
import com.tbiss.hroof.repository.language.LanguageRepository;
import com.tbiss.hroof.repository.question.QuestionRepository;
import com.tbiss.hroof.repository.user.AdminRepository;
import com.tbiss.hroof.repository.user.CompetitorRepository;
import com.tbiss.hroof.repository.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    AdminRepository adminRepository ;
    @Autowired
    CompetitorRepository competitorRepository ;
    @Autowired
    LanguageRepository languageRepository ;
    @Autowired
    CategoryRepository categoryRepository ;
    @Autowired
    QuestionRepository questionRepository ;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Bootstrap.........");

        bootstrapUsers();
        bootstrapLanguages();

        User user = new User();
        user.setUsername("user");
        user.setPassword(this.passwordEncoder.encode("password"));
        user.setRoles(Arrays.asList( "ROLE_USER"));


        this.userRepository.save(user );


        User user2 = new User();
        user2.setUsername("admin");
        user2.setEmail("mamdouh@nakeeb.me");
        user2.setPassword(this.passwordEncoder.encode("password"));
        user2.setRoles(Arrays.asList( "ROLE_ADMIN"));


        this.userRepository.save(user2);


        logger.debug("printing all users...");

    }


    private void bootstrapQuestions(Category category){

        Question question = new Question();
        question.setName("How Are you ?");
        question.setCategory(category);
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer(question,"Fine",true));
        answers.add(new Answer(question,"Good",false));
        answers.add(new Answer(question,"Khaled",false));
        answers.add(new Answer(question,"Aly",false));

        question.setAnswers(answers);

        questionRepository.save(question);
    }

    private void bootstrapLanguages() {

        Language english = createLanguage("English","en", LanguageDirection.LTR);
        Language arabic = createLanguage("Arabic","ar", LanguageDirection.RTL);

        Category technology = createCategory("Technology","is section for technologies","https://placeholder.com",english);

        bootstrapQuestions(technology);

    }

    private Category createCategory(String name, String description, String cover, Language language) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setCover(cover);
        logger.info("Language Id: "+language.getId());
        category.setLanguage(language);

        Category savedCategory =  categoryRepository.save(category) ;




        return savedCategory ;
    }

    private void bootstrapUsers() {
        competitorRepository.save(createUser("Khaled","khaled@tbiss.com","123456"));
        competitorRepository.save(createUser("Pola","pola@tbiss.com","123456"));
        competitorRepository.save(createUser("Aly","aly@tbiss.com","123456"));

        logger.info("Users Size: " +competitorRepository.findAll().size());

        User user2 = new User();
        user2.setName("Administrator");
        user2.setPassword("1234567");
        user2.setEmail("admin@tbiss.com");


        Admin admin2 = new Admin(user2.getName(),user2.getEmail(),user2.getPassword());
        admin2.setPrevilgies("Test #1");

        adminRepository.save(admin2);

        List<Admin> admins = adminRepository.findAll();

        logger.info("Admins Size: " +admins.size());
        logger.info("Users Size: " +competitorRepository.findAll().size());
    }


    public Competitor createUser(String name, String email, String password){
        Competitor competitor = new Competitor(name,email,password);

        return competitor ;
    }

    public Language createLanguage(String name,String code,LanguageDirection direction){
        Language language = new Language();
        language.setName(name);
        language.setCode(code);
        language.setDirection(direction);

        Language savedLanguage = languageRepository.save(language);

        return savedLanguage ;
    }


}
