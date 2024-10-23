/* 
 * Sergio WU CB3025691
 * Jackson de Lima Gregorio CB3013189
*/

package TP02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TP02 extends JFrame {
    private JTextField nomeField;
    private JTextField enderecoField;
    private JTextField idadeField;
    private List<Aluno> alunos;

    public TP02() {
        alunos = new ArrayList<>();

        setTitle("Cadastro de Alunos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Labels and text fields
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Endereço:"));
        enderecoField = new JTextField();
        add(enderecoField);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        add(idadeField);

        // Buttons
        JButton okButton = new JButton("Adicionar");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });
        add(okButton);

        JButton limparButton = new JButton("Limpar");
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        add(limparButton);

        JButton mostrarButton = new JButton("Mostrar");
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlunos();
            }
        });
        add(mostrarButton);

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(sairButton);
    }

    private void cadastrarAluno() {
        String nome = nomeField.getText();
        String endereco = enderecoField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        UUID uuid = UUID.randomUUID();

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEndereco(endereco);
        aluno.setIdade(idade);
        aluno.setUuid(uuid);

        alunos.add(aluno);
        limparCampos();
    }

    private void limparCampos() {
        nomeField.setText("");
        enderecoField.setText("");
        idadeField.setText("");
    }

    private void mostrarAlunos() {
        StringBuilder mensagem = new StringBuilder();
        for (Aluno aluno : alunos) {
            mensagem.append("ID: ").append(aluno.getUuid()).append(", Nome: ").append(aluno.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(this, mensagem.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TP02().setVisible(true);
            }
        });
    }

    // Classe Aluno
    static class Aluno {
        private String endereco;
        private int idade;
        private String nome;
        private UUID uuid;

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public UUID getUuid() {
            return uuid;
        }

        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }
    }
}