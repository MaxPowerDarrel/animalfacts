package animals.ui;

import animals.services.AnimalFact;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class UI extends JFrame {
    private final JTextField textField = new JTextField();
    private final JButton catFactButton = new JButton("Cat Fact");
    private final JButton dogFactButton = new JButton("Dog Fact");

    public UI(AnimalFact dogFact, AnimalFact catFact) {
        super("Animal Facts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents(dogFact, catFact);
        setPreferredSize(new Dimension(800, 100));
        pack();
        setVisible(true);
    }

    private void initializeComponents(AnimalFact dogFact, AnimalFact catFact) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        final Insets insets = new Insets(10, 10, 0, 10);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 4;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        getContentPane().add(textField, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = insets;
        dogFactButton.addActionListener(event -> textField.setText(dogFact.getFact()));
        getContentPane().add(dogFactButton, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.insets = insets;
        catFactButton.addActionListener(event -> textField.setText(catFact.getFact()));
        getContentPane().add(catFactButton, constraints);
    }
}
