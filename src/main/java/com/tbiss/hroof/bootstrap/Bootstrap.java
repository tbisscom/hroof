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

        List<Answer> q1Answers = new ArrayList<>();
        q1Answers.add(new Answer("برلين",false));
        q1Answers.add(new Answer("روما",false));
        q1Answers.add(new Answer("أثينا",true));
        q1Answers.add(new Answer("باريس",false));


        Question q1 = createQuestion(category,"أين أقيمت أول دورة أولمبية حديثة؟");
        questionRepository.save(createAnswers(q1,q1Answers));


        List<Answer> q2Answers = new ArrayList<>();
        q2Answers.add(new Answer("12",false));
        q2Answers.add(new Answer("8",false));
        q2Answers.add(new Answer("10",true));
        q2Answers.add(new Answer("14",false));

        Question q2 = createQuestion(category,"كم عدد القوارير في بطولة البولينج؟");
        questionRepository.save(createAnswers(q2,q2Answers));


        //===============================

        List<Answer> q3Answers = new ArrayList<>();
        q3Answers.add(new Answer("السعودية",false));
        q3Answers.add(new Answer("قطر",false));
        q3Answers.add(new Answer("اليابان",true));
        q3Answers.add(new Answer("ماليزيا",false));

        Question q3 = createQuestion(category,"من الفائز ببطولة آسيا الأولى للناشئين لكرة القدم؟");
        questionRepository.save(createAnswers(q3,q3Answers));



        //===============================

        List<Answer> q4Answers = new ArrayList<>();
        q4Answers.add(new Answer("الكويت",false));
        q4Answers.add(new Answer("الإمارات",false));
        q4Answers.add(new Answer("قطر",true));
        q4Answers.add(new Answer("السعودية",false));

        Question q4 = createQuestion(category,"من أول فريق عربي يحصل على بطولة الأمم الآسيوية؟");
        questionRepository.save(createAnswers(q4,q4Answers));

        //===============================

        List<Answer> q5Answers = new ArrayList<>();
        q5Answers.add(new Answer("التمارين الرئيسية للكاراتية",false));
        q5Answers.add(new Answer("التمارين الرئيسية للجودو",false));
        q5Answers.add(new Answer("التمارين الرئيسية للكونج فو",true));
        q5Answers.add(new Answer("التمارين الرئيسية للتايكندو",false));

        Question q5 = createQuestion(category,"ماذا تعني كلمة الكاتا؟");
        questionRepository.save(createAnswers(q5,q5Answers));

        //===============================

        List<Answer> q6Answers = new ArrayList<>();
        q6Answers.add(new Answer("إسماعيل بن إبراهيم عليه السلام",false));
        q6Answers.add(new Answer("خالد بن الوليد",false));
        q6Answers.add(new Answer("معاوية بن أبى سفيان",true));
        q6Answers.add(new Answer("عمر بن الخطاب",false));

        Question q6 = createQuestion(category,"من أول من ركب الخيل ؟");
        questionRepository.save(createAnswers(q6,q6Answers));

        //===============================

        List<Answer> q7Answers = new ArrayList<>();
        q7Answers.add(new Answer("المجر",false));
        q7Answers.add(new Answer("السلفادور",false));
        q7Answers.add(new Answer("المجر",true));
        q7Answers.add(new Answer("السلفادور",false));

        Question q7 = createQuestion(category,"ما أعلى النتائج في كأس العالم لكرة القدم؟");
        questionRepository.save(createAnswers(q7,q7Answers));

        //===============================

        List<Answer> q8Answers = new ArrayList<>();
        q8Answers.add(new Answer("لا يقل عن 800م.",false));
        q8Answers.add(new Answer("لا يقل عن 500م.",false));
        q8Answers.add(new Answer("لا يقل عن 400م.",true));
        q8Answers.add(new Answer("لا يقل عن 600م.",false));

        Question q8 = createQuestion(category,"كم طول المضمار في سباقات ألعاب القوى؟");
        questionRepository.save(createAnswers(q8,q8Answers));

        //===============================

        List<Answer> q9Answers = new ArrayList<>();
        q9Answers.add(new Answer("الجزائر",false));
        q9Answers.add(new Answer("السعودية",false));
        q9Answers.add(new Answer("مصر",true));
        q9Answers.add(new Answer("المغرب",false));

        Question q9 = createQuestion(category,"من أول المتأهلين العرب لنهائيات كأس العالم لكرة القدم؟");
        questionRepository.save(createAnswers(q9,q9Answers));

        //===============================

        List<Answer> q10Answers = new ArrayList<>();
        q10Answers.add(new Answer("15م × 20م.",false));
        q10Answers.add(new Answer("40م × 50م.",false));
        q10Answers.add(new Answer("28م × 25م",true));
        q10Answers.add(new Answer("32م × 30م.",false));

        Question q10 = createQuestion(category,"كم مقاس ملعب كرة السلة الأولمبي؟");
        questionRepository.save(createAnswers(q10,q10Answers));





    }


    private Question createQuestion(Category category,String q){
        Question question = new Question();
        question.setName(q);
        question.setCategory(category);


        return question ;
    }

    private Question createAnswers(Question question ,List<Answer> answers){
        List<Answer> finalAnswers = new ArrayList<>();
        for (int i = 0 ; i <answers.size();i++){
            Answer answer = answers.get(i);
            answer.setQuestion(question);
            finalAnswers.add(answer);
        }


        question.setAnswers(finalAnswers);

        return question;
    }
    private void bootstrapLanguages() {

        Language english = createLanguage("English","en", LanguageDirection.LTR);
        Language arabic = createLanguage("Arabic","ar", LanguageDirection.RTL);

        Category technology = createCategory("رياضة","is section for technologies","https://placeholder.com",arabic);

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
