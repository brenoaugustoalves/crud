package view;

import Controller.UserController;
import Model.User;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class UserView extends JFrame {

    private final UserController userController;
    private final JTextField nameField;
    private final JTextField emailField;
    private JTextField cpfField;
    private final JTextField passwordField;
    private final JTextField filterField;
    private final JTextArea userListTextArea;

    public UserView() {
        userController = new UserController();

        setTitle("Sistema de Gerenciamento de clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Nome");
        nameLabel.setBounds(10, 10, 80, 25);
        add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(100, 10, 160, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 70, 100, 25);
        add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 70, 160, 25);
        add(emailField);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setBounds(10, 100, 80, 25);
        add(cpfLabel);

        try {
            MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
            cpfField = new JFormattedTextField(cpfFormatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cpfField.setBounds(100, 100, 160, 25);
        add(cpfField);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 130, 80, 25);
        add(passwordLabel);

        passwordField = new JTextField(20);
        passwordField.setBounds(100, 130, 160, 25);
        add(passwordField);

        JButton addButton = new JButton("Adicionar cliente");
        addButton.setBounds(10, 160, 130, 25);
        add(addButton);

        JButton editButton = new JButton("Editar cliente");
        editButton.setBounds(140, 160, 120, 25);
        add(editButton);

        JButton deleteButton = new JButton("deletar cliente");
        deleteButton.setBounds(270, 160, 120, 25);
        add(deleteButton);

        JLabel filterLabel = new JLabel("Filtrar cliente:");
        filterLabel.setBounds(10, 190, 80, 25);
        add(filterLabel);

        filterField = new JTextField(20);
        filterField.setBounds(100, 190, 160, 25);
        add(filterField);

        JButton filterButton = new JButton("Filtrar");
        filterButton.setBounds(270, 190, 120, 25);
        add(filterButton);

        userListTextArea = new JTextArea();
        userListTextArea.setBounds(10, 220, 560, 130);
        add(userListTextArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = new User();
                    user.setName(nameField.getText());
                    user.setEmail(emailField.getText());
                    user.setCpf(cpfField.getText());
                    user.setPassword(passwordField.getText());
                    userController.addUser(user);
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso! ");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar o cliente: " + ex.getMessage());
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = new User();
                    user.setName(nameField.getText());
                    user.setEmail(emailField.getText());
                    user.setCpf(cpfField.getText());
                    user.setPassword(passwordField.getText());
                    userController.updateUser(user);
                    JOptionPane.showMessageDialog(null, "Atualizado cliente!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + ex.getMessage());
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cpf = cpfField.getText();
                    userController.deleteUser(cpf);
                    JOptionPane.showMessageDialog(null, "Deletado cliente");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar cliente: " + ex.getMessage());
                }
            }
        });

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String filter = filterField.getText();
                    List<User> users = userController.listUsers(filter);
                    userListTextArea.setText("");
                    for (User user : users) {
                        userListTextArea.append(user.getName() + " - "  + " - " + user.getEmail() + " - " + user.getCpf() + "\n");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao listar clientes! " + ex.getMessage());
                }
            }
        });
    }
}
