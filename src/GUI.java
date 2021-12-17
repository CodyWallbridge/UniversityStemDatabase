import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class GUI{
    private static Database db;
    private static int currentQueryIndex;
    private static JFrame f;


    public static void main(String[] args) {
        db = new Database();
        db.executeQuery(0);


        f = new JFrame("University of Manitoba STEM Database (2019/2020)");//creating instance of JFrame
        // shows all the options in the drop-down menus
        startingPoint();
        // departmentOptions();
    }

    // ------------------------------------------------------------------------------------------
    // Purpose: This is the initial frame the user sees. They select what category they are
    // interested in.
    // -------------------------------------------------------------------------------------------
    public static void startingPoint(){
//        JFrame f = new JFrame("University of Manitoba STEM Database");//creating instance of JFrame
        // Creating a panel to add buttons
        JPanel p = new JPanel();
        final JLabel welcomeLabel = new JLabel("Welcome to the University of Manitoba STEM databse");
        final JLabel ourNames = new JLabel("Made by Cody Wallbridge and Kajal Tomar");
        final JRadioButton courses = new JRadioButton("Courses");
        final JRadioButton departments = new JRadioButton("Deparments");
        final JRadioButton faculties = new JRadioButton("Faculties");

        final JLabel categories = new JLabel("Pick the category that you are curious about: ");

        p.setLayout(null);

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setSize(800,200);
        welcomeLabel.setFont(new Font("Monospaced", Font.BOLD, 20));

        ourNames.setHorizontalAlignment(JLabel.CENTER);
        ourNames.setSize(800,250);
        ourNames.setFont(new Font("Monospaced", Font.BOLD, 12));

        categories.setHorizontalAlignment(JLabel.CENTER);
        categories.setSize(800,400);
        categories.setFont(new Font("Monospaced", Font.BOLD, 15));

        courses.setBounds(200,225,100,30);
        departments.setBounds(200,250,100,30);
        faculties.setBounds(200,275,100,30);

        p.add(welcomeLabel);
        p.add(ourNames);
        p.add(categories);

        p.add(courses);
        p.add(departments);
        p.add(faculties);

        f.setContentPane(p);
        f.setLayout(null);
        f.setSize(800,800);
        f.setVisible(true);

        courses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(courses.isSelected()){
                    courseOptions();
                }
            }
        });

        departments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(departments.isSelected()){
                    departmentOptions();
                }
            }
        });

        faculties.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(faculties.isSelected()){
                    facultyOptions();
                }
            }
        });
    }

    // ------------------------------------------------------------------------------------------
    // Purpose: shows all the query options. Saves the option that is picked by the user and
    //          calls executeQuery for the given query.
    // -------------------------------------------------------------------------------------------
    public static void departmentOptions(){
//        JFrame f = new JFrame("University of Manitoba STEM Database");//creating instance of JFrame
        JButton resultButton = new JButton("select");
        JButton backButton = new JButton("home");
        JPanel p = new JPanel();
        final JComboBox alloptions;
        final JLabel welcomeLabel = new JLabel("Select what you are curious about and we will show you the results!");
//        final JLabel currentQueryLabel = new JLabel();
//
//        currentQueryLabel.setHorizontalAlignment(JLabel.CENTER);
//        currentQueryLabel.setSize(400,600);

        String allQueries[]={"Show all the departments, their contact information and which faculty they are a part of.",
                "Show all the courses offered by each department.",
                "Show all the employees and which department they work in.",
                "Which departments do the 3 highest paid faculty members work for?",
                "Which departments do the 3 lowest paid faculty members work for?",
                "Which department has the most instructors?",
                "Which department has the least instructors?",
                "Which department paid out the most in compensation?",
                "Which department paid out the least in compensation?",
                "Which department paid the most on average?",
                "What is the total compensation awarded by X department?"};

        p.setLayout(null);

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setSize(800,200);
        welcomeLabel.setFont(new Font("Monospaced", Font.BOLD, 16));

        alloptions = new JComboBox(allQueries);

        alloptions.setBounds(50, 200,600,30);
        resultButton.setBounds(655,200,100,30);
        backButton.setBounds(360,5,80,20);

        p.add(welcomeLabel);
        p.add(alloptions);
        //    f.add(currentQueryLabel);
        p.add(resultButton);
        p.add(backButton);
        f.setContentPane(p);

//        f.setLayout(null);
//        f.setSize(800,800);
        f.setVisible(true);

        alloptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                String data = "Current Query: "
//                        + alloptions.getItemAt(alloptions.getSelectedIndex());
//                currentQueryLabel.setText(data);
                currentQueryIndex = alloptions.getSelectedIndex();
            }
        });

        resultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(currentQueryIndex);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startingPoint();
            }
        });
    }

    // ------------------------------------------------------------------------------------------
    // Purpose: shows all the query options. Saves the option that is picked by the user and
    //          calls executeQuery for the given query.
    // -------------------------------------------------------------------------------------------
    public static void facultyOptions(){
//        JFrame f = new JFrame("University of Manitoba STEM Database");//creating instance of JFrame
        JButton resultButton = new JButton("select");
        JButton backButton = new JButton("home");
        JPanel p = new JPanel();
        final JComboBox alloptions;
        final JLabel welcomeLabel = new JLabel("Select what you are curious about and we will show you the results!");
//        final JLabel currentQueryLabel = new JLabel();
//
//        currentQueryLabel.setHorizontalAlignment(JLabel.CENTER);
//        currentQueryLabel.setSize(400,600);

        String allQueries[]={"Show all the faculties and any other related information about each faculty.",
                "Show all the courses offered by each faculty.",
                "Show all the employees and which faculty they work in.",
                "Which faculty gave the most As?",
                "Which faculty gave the most Fs?",
                "Which faculty has the lowest tuition for international students  and how do I contact them?",
                "Which faculty has the highest average grade for international students? How do I contact them?",
                "Which faculty has the lowest tuition for domestic students and how do I contact them? ",
                "Which faculty has the highest average grade for domestic students? How do I contact them?",
                "What is the total compensation awarded by X department?"};

        p.setLayout(null);

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setSize(800,200);
        welcomeLabel.setFont(new Font("Monospaced", Font.BOLD, 16));

        alloptions = new JComboBox(allQueries);

        alloptions.setBounds(50, 200,600,30);
        resultButton.setBounds(655,200,100,30);
        backButton.setBounds(360,5,80,20);

        p.add(welcomeLabel);
        p.add(alloptions);
        //    f.add(currentQueryLabel);
        p.add(resultButton);
        p.add(backButton);
        f.setContentPane(p);

//        f.setLayout(null);
//        f.setSize(800,800);
        f.setVisible(true);

        alloptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                String data = "Current Query: "
//                        + alloptions.getItemAt(alloptions.getSelectedIndex());
//                currentQueryLabel.setText(data);
                currentQueryIndex = alloptions.getSelectedIndex();
            }
        });

        resultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(currentQueryIndex);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startingPoint();
            }
        });
    }

    // ------------------------------------------------------------------------------------------
    // Purpose: shows all the query options. Saves the option that is picked by the user and
    //          calls executeQuery for the given query.
    // -------------------------------------------------------------------------------------------
    public static void courseOptions(){
//        JFrame f = new JFrame("University of Manitoba STEM Database");//creating instance of JFrame
        JButton resultButton = new JButton("select");
        JButton backButton = new JButton("home");
        JPanel p = new JPanel();
        final JComboBox alloptions;
        final JLabel welcomeLabel = new JLabel("Select what you are curious about and we will show you the results!");
//        final JLabel currentQueryLabel = new JLabel();
//
//        currentQueryLabel.setHorizontalAlignment(JLabel.CENTER);
//        currentQueryLabel.setSize(400,600);

        String allQueries[]={"Show all the teachers and related information.",
                "Show all the available courses offered in. ",
                "Show all the registration information about all of the courses offered. ",
                "Which courses are offered in all 3 terms?",
                "Which course had the most empty seats for the year?",
                "Which course from a department is most popular?",
                "Which course from a department is least popular?"};

        p.setLayout(null);

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setSize(800,200);
        welcomeLabel.setFont(new Font("Monospaced", Font.BOLD, 16));

        alloptions = new JComboBox(allQueries);

        alloptions.setBounds(50, 200,600,30);
        resultButton.setBounds(655,200,100,30);
        backButton.setBounds(360,5,80,20);

        p.add(welcomeLabel);
        p.add(alloptions);
        //    f.add(currentQueryLabel);
        p.add(resultButton);
        p.add(backButton);
        f.setContentPane(p);

//        f.setLayout(null);
//        f.setSize(800,800);
        f.setVisible(true);

        alloptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                String data = "Current Query: "
//                        + alloptions.getItemAt(alloptions.getSelectedIndex());
//                currentQueryLabel.setText(data);
                currentQueryIndex = alloptions.getSelectedIndex();
            }
        });

        resultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(currentQueryIndex);
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startingPoint();
            }
        });
    }

}

