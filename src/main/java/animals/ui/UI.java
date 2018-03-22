package animals.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.function.Supplier;

public class UI extends JFrame {
    private final JTextField textField = new JTextField();
    private final JButton catFactButton = new JButton("Cat Fact");
    private final JButton dogFactButton = new JButton("Dog Fact");

    public UI(Supplier<String> dogFact, Supplier<String> catFact) {
        super("Animal Facts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents(dogFact, catFact);
        setPreferredSize(new Dimension(800, 100));
        pack();
        setVisible(true);
    }

    private void initializeComponents(Supplier<String> dogFact, Supplier<String> catFact) {
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
        dogFactButton.addActionListener(event -> textField.setText(dogFact.get()));
        getContentPane().add(dogFactButton, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.insets = insets;
        catFactButton.addActionListener(event -> textField.setText(catFact.get()));
        getContentPane().add(catFactButton, constraints);
    }
}
