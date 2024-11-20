/* 
 * Sergio WU CB3025691
 * Jackson de Lima Gregorio CB3013189
*/

package TP03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoav3 extends JFrame {
    private JTextField numeroField;
    private JTextField nomeField;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femininoRadioButton;
    private JTextField idadeField;
    private Pessoa umaPessoa;

    public FormPessoav3() {
        setTitle("FormPessoa");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Numero:"));
        numeroField = new JTextField();
        numeroField.setEditable(false);
        add(numeroField);

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Sexo:"));
        JPanel sexoPanel = new JPanel();
        masculinoRadioButton = new JRadioButton("Masculino");
        femininoRadioButton = new JRadioButton("Feminino");
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(masculinoRadioButton);
        sexoGroup.add(femininoRadioButton);
        sexoPanel.add(masculinoRadioButton);
        sexoPanel.add(femininoRadioButton);
        add(sexoPanel);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        add(idadeField);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    char sexo = masculinoRadioButton.isSelected() ? 'M' : 'F';
                    int idade = Integer.parseInt(idadeField.getText());

                    umaPessoa = new Pessoa(nome, sexo, idade);

                    numeroField.setText(String.valueOf(Pessoa.getKp()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(FormPessoav3.this, "Erro: " + ex.getMessage());
                }
            }
        });
        add(okButton);

        JButton mostrarButton = new JButton("Mostrar");
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (umaPessoa != null) {
                    JOptionPane.showMessageDialog(FormPessoav3.this,
                            "Numero: " + Pessoa.getKp() + "\n" +
                            "Nome: " + umaPessoa.getNome() + "\n" +
                            "Sexo: " + umaPessoa.getSexo() + "\n" +
                            "Idade: " + umaPessoa.getIdade());
                } else {
                    JOptionPane.showMessageDialog(FormPessoav3.this, "Nenhuma pessoa cadastrada.");
                }
            }
        });
        add(mostrarButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormPessoav3().setVisible(true);
            }
        });
    }
}

class Pessoa {
    private static int kp = 0;
    private String nome;
    private char sexo;
    private int idade;

    public Pessoa() {
        kp++;
    }

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;
    }

    public static int getKp() {
        return kp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            throw new IllegalArgumentException("Sexo deve ser 'M' ou 'F'");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}