import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Zodiac {

    private String name;
    private int age;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String zodiacSign;
    private String destiny;
    private int luckyNumber;
    private String loveLife;

    // Constructor to initialize the object with user input
    public Zodiac() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        this.name = input.nextLine();
        System.out.print("Enter your birth day: ");
        this.birthDay = input.nextInt();
        System.out.print("Enter your birth month (1-12): ");
        this.birthMonth = input.nextInt();
        System.out.print("Enter your birth year: ");
        this.birthYear = input.nextInt();

        // Calculate age
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        this.age = Period.between(birthDate, LocalDate.now()).getYears();

        // Determine Zodiac Sign, Destiny, Lucky Number, and Love Life
        calculateZodiac();
    }

    // Method to calculate and set Zodiac details
    private void calculateZodiac() {
        switch (birthMonth) {
            case 1:
                if (birthDay <= 19) {
                    zodiacSign = "Capricorn";
                    destiny = "They tend to have a strong sense of responsibility and ambition, which can lead them to achieve their goals.";
                    luckyNumber = 3;
                    loveLife = "They take relationships seriously and may be cautious when opening up emotionally.";
                } else {
                    zodiacSign = "Aquarius";
                    destiny = "They tend to excel in fields that allow them to express their creativity, such as technology, science, and the arts.";
                    luckyNumber = 4;
                    loveLife = "They are often attracted to partners who respect their need for space and can engage in deep, meaningful conversations.";
                }
                break;
            case 2:
                if (birthDay <= 18) {
                    zodiacSign = "Aquarius";
                    destiny = "They tend to excel in fields that allow them to express their creativity, such as technology, science, and the arts.";
                    luckyNumber = 4;
                    loveLife = "They are often attracted to partners who respect their need for space and can engage in deep, meaningful conversations.";
                } else {
                    zodiacSign = "Pisces";
                    destiny = "Empathetic and intuitive dreamers, often destined for creative pursuits and drawn to helping others through artistic expression and supportive roles.";
                    luckyNumber = 9;
                    loveLife = "Romantic and idealistic partners who seek deep emotional connections, are sensitive and understanding in relationships, and are attracted to emotionally available individuals who value their caring nature.";
                }
                break;
            case 3:
                if (birthDay <= 20) {
                    zodiacSign = "Pisces";
                    destiny = "Empathetic and intuitive dreamers, often destined for creative pursuits and drawn to helping others through artistic expression and supportive roles.";
                    luckyNumber = 9;
                    loveLife = "Romantic and idealistic partners who seek deep emotional connections, are sensitive and understanding in relationships, and are attracted to emotionally available individuals who value their caring nature.";
                } else {
                    zodiacSign = "Aries";
                    destiny = "Their destiny often involves leadership roles, adventure, and pursuing their passions.";
                    luckyNumber = 1;
                    loveLife = "They are attracted to partners who can match their energy and excitement.";
                }
                break;
            case 4:
                if (birthDay <= 19) {
                   zodiacSign = "Aries";
                   destiny = "Their destiny often involves leadership roles, adventure, and pursuing their passions.";
                   luckyNumber = 7;
                   loveLife = "They are attracted to partners who can match their energy and excitement.";
                } else {
                    zodiacSign = "Taurus";
                    destiny = "They often have a destiny tied to building stability and security in their lives.";
                    luckyNumber = 6;
                    loveLife = "They value stability and tend to take their time in relationships, preferring to build strong foundations before fully committing.";
                }
                break;
            case 5:
                if (birthDay <= 20) {
                    zodiacSign = "Taurus";
                    destiny = "They often have a destiny tied to building stability and security in their lives.";
                    luckyNumber = 6;
                    loveLife = "They value stability and tend to take their time in relationships, preferring to build strong foundations before fully committing.";
                } else {
                    zodiacSign = "Gemini";
                    destiny = "Adaptable, curious, and sociable individuals who excel in communication, thrive in diverse careers due to their quick thinking, and build valuable connections through their networking skills.";
                    luckyNumber = 5;
                    loveLife = "Engaging partners who attract others with their charm and wit, often seek variety in relationships, and value open communication with partners who can engage in stimulating conversations.";
                }
                break;
            case 6:
                if (birthDay <= 20) {
                    zodiacSign = "Gemini";
                    destiny = "Adaptable, curious, and sociable individuals who excel in communication, thrive in diverse careers due to their quick thinking, and build valuable connections through their networking skills.";
                    luckyNumber = 5;
                    loveLife = "Engaging partners who attract others with their charm and wit, often seek variety in relationships, and value open communication with partners who can engage in stimulating conversations.";
                } else {
                    zodiacSign = "Cancer";
                    destiny = "Their emotional depth allows them to connect deeply with others, making them natural caregivers and protectors.";
                    luckyNumber = 7;
                    loveLife = "They tend to be romantic and seek deep emotional connections with their partners.";
                }
                break;
            case 7:
                if (birthDay <= 22) {
                    zodiacSign = "Cancer";
                    destiny = "Their emotional depth allows them to connect deeply with others, making them natural caregivers and protectors.";
                    luckyNumber = 7;
                    loveLife = "They tend to be romantic and seek deep emotional connections with their partners."; 
                } else {
                    zodiacSign = "Leo";
                    destiny = "Their destiny is typically characterized by opportunities to shine, inspire others, and achieve recognition for their talents.";
                    luckyNumber = 10;
                    loveLife = "They enjoy being in relationships that allow them to express their creativity and passion.";
                }
                break;
            case 8:
                if (birthDay <= 22) {
                    zodiacSign = "Leo";
                    destiny = "Their destiny is typically characterized by opportunities to shine, inspire others, and achieve recognition for their talents.";
                    luckyNumber = 10;
                    loveLife = "They enjoy being in relationships that allow them to express their creativity and passion.";
                } else {
                    zodiacSign = "Virgo";
                    destiny = "Often seen as reliable, hardworking, and methodical. They excel in roles that require organization and analytical skills.";
                    luckyNumber = 14;
                    loveLife = "Often devoted and loyal partners. They seek stability and practicality in relationships.";
                }
                break;
            case 9:
                if (birthDay <= 22) {
                    zodiacSign = "Virgo";
                    destiny = "Often seen as reliable, hardworking, and methodical. They excel in roles that require organization and analytical skills.";
                    luckyNumber = 14;
                    loveLife = "Often devoted and loyal partners. They seek stability and practicality in relationships. ";
                } else {
                    zodiacSign = "Libra";
                    destiny = "They are natural peacemakers who value harmony and balance in all aspects of life.";
                    luckyNumber = 2;
                    loveLife = "They seek deep connections and often fall in love easily, attracted to beauty and charm in others.";
                }
                break;
            case 10:
                if (birthDay <= 22) {
                    zodiacSign = "Libra";
                    destiny = "They are natural peacemakers who value harmony and balance in all aspects of life.";
                    luckyNumber = 22;
                    loveLife = "They seek deep connections and often fall in love easily, attracted to beauty and charm in others.";
                } else {
                    zodiacSign = "Scorpio";
                    destiny = "They often face challenges that lead them to profound personal growth.";
                    luckyNumber = 11;
                    loveLife = "They seek deep emotional connections and are often very loyal partners.";
                }
                break;
            case 11:
                if (birthDay <= 21) {
                    zodiacSign = "Scorpio";
                    destiny = "They often face challenges that lead them to profound personal growth.";
                    luckyNumber = 11;
                    loveLife = "They seek deep emotional connections and are often very loyal partners.";
                } else {
                    zodiacSign = "Sagittarius";
                    destiny = "Their destiny often involves exploration, whether that’s through travel, education, or personal growth.";
                    luckyNumber = 12;
                    loveLife = "They value honesty and independence, often seeking partners who can match their enthusiasm for life.";
                }
                break;
            case 12:
                if (birthDay <= 21) {
                    zodiacSign = "Sagittarius";
                    destiny = "Their destiny often involves exploration, whether that’s through travel, education, or personal growth.";
                    luckyNumber = 12;
                    loveLife = "They value honesty and independence, often seeking partners who can match their enthusiasm for life.";
                } else {
                    zodiacSign = "Capricporn";
                    destiny = "They tend to have a strong sense of responsibility and ambition, which can lead them to achieve their goals.";
                    luckyNumber = 3;
                    loveLife = "They take relationships seriously and may be cautious when opening up emotionally.";
                }
                break;
        }
    }

    // Getters to access the private members
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public String getDestiny() {
        return destiny;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    public String getLoveLife() {
        return loveLife;
    }

    public static void main(String[] args) {
        Zodiac user = new Zodiac();

     System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Zodiac Sign: " + user.getZodiacSign());
        System.out.println("Destiny: " + user.getDestiny());
        System.out.println("Lucky Number: " + user.getLuckyNumber());
        System.out.println("Love Life: " + user.getLoveLife());
    }
}