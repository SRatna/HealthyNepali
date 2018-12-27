package com.practice.osho.healthynepali;

/**
 * Created by osho on 11/7/15.
 */
public class Quiz_Questions {
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String correctAnswer;

    private Quiz_Questions(String question, String ans1, String ans2, String ans3, String ans4, String correctAnswer){
        this.question=question;
        this.ans1=ans1;
        this.ans2=ans2;
        this.ans3=ans3;
        this.ans4=ans4;
        this.correctAnswer=correctAnswer;
    }

    public static Quiz_Questions[] questions={
            //for quiz_basic level
            new Quiz_Questions("Which organ belongs to the Digestive System","Trachea","Stomach","Heart","Thymus","Stomach"),
            new Quiz_Questions("The percentage of water in human body is","50 %","60 %","66 %","70 %","66 %"),
            new Quiz_Questions("What is the term which describes the joining together of a sperm and an egg?","Fertilization","Reproduction","Duplication","Ovulation","Fertilization"),
            new Quiz_Questions("Normal blood pressure of human being is","120/80 mm Hg","120/70 mm Hg","100/80 mm Hg","70/70 mm Hg","120/80 mm Hg"),
            new Quiz_Questions("An average heartbeat lasts approximately","0.08 seconds","60 seconds","80 seconds","0.8 seconds","0.8 seconds"),
            new Quiz_Questions("The smallest bone in the human body is about the size of","A grain of rice","A thumb pin","A size of coffee","An eyelash","A grain of rice"),
            new Quiz_Questions("The smallest bones in the human body are found in the","Ear","Head","Knees","Fingers","Ear"),
            new Quiz_Questions("How many taste buds are there in our tongue?","5000","7000","9000","3000","9000"),
            //for quiz_intermediate level
            new Quiz_Questions("What is the largest organ of the human body?","The skin","Head","Thigh","Shoulder","The skin"),
            new Quiz_Questions("The cause of night blindness is","Vitamin A","Vitamin B","Vitamin C","Vitamin D","Vitamin A"),
            new Quiz_Questions("Smallpox vaccine was discovered by","Jenner","Pasteur","Flemming","Hooke","Jenner"),
            new Quiz_Questions("What are the defect of vitamin B6?","Beriberi","Scurvy","Certain type of eczema","Dermatomayma","Certain type of eczema"),
            new Quiz_Questions("Which of the following diseases is associated with Vitamin C deficiency ?","Psoriasis","Scurvy","Pellagra","Vitiligo","Scurvy"),
            new Quiz_Questions("Marfan syndrome is caused by mutation in a gene that encode the following protein?","Myosin","Collagen","Actin","Fibrillin","Fibrillin"),
            new Quiz_Questions("In which structure is blood filtered within the kidneys?","Bladder","Ureter","Nephron","Adrenals","Nephron"),
            new Quiz_Questions("One important function of bones is to produce ","Tendon","Blood cells","Cartilage","Ligaments","Blood cells"),
            //for quiz_tough level
            new Quiz_Questions("Low blood pressure is known as ","Hypertension","Hypotension","Hypoglycaemia","Hypokalaemia","Hypotension"),
            new Quiz_Questions("The amount of blood pumped by the heart in a minute is","Vascular resistance","Cardiac output","Heart rate","Stroke volume","Cardiac output"),
            new Quiz_Questions("The gland often referred to as the \'Master gland\' is the","Pituitary Gland","Master gland","Normal gland","Testis gland","Pituitary Gland"),
            new Quiz_Questions("Cranial bones include all of the following except?","Parietal","Maxilla","Frontal","Ethmoid","Maxilla"),
            new Quiz_Questions("When the left atrium relaxes, blood enters this chamber through the","Coronary sinus","AV node","Bundle of his","Pulmonary veins","Pulmonary Veins"),
            new Quiz_Questions("Which artery is used to take a patient's blood pressure?","Pulmonary artery","Right artery","Left Artery","Brachial artery","Brachial artery"),
            new Quiz_Questions("what do you want to avoid during CPR?","Hyperventilation","Defibrillation","Hypoventilation","Breaking ribs","Hyperventilation"),
            new Quiz_Questions("Calcium crystals are a normal part of which body region?","The spine","The gouty joints","The nasal cavity","The ears","The ears")
    };

    public String getQuestion(){
        return question;
    }
    public String getAns1(){
        return ans1;
    }
    public String getAns2(){
        return ans2;
    }
    public String getAns3(){
        return ans3;
    }
    public String getAns4(){
        return ans4;
    }
    public String getCorrectAnswer(){
        return correctAnswer;
    }

}
