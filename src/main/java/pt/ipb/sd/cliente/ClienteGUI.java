package pt.ipb.sd.cliente;

import java.rmi.RemoteException;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pt.ipb.sd.interfaces.NavegadorRemote;

public class ClienteGUI extends javax.swing.JFrame {

    private final NavegadorRemote nr;
    private String diretoriaAtual;
    private final String[] extensoesEditaveis;
    private final String txtEditarDefault;

    public ClienteGUI(NavegadorRemote nr) {
        this.initComponents();
        this.setTitle("Sistema de Ficheiros Remoto");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.nr = nr;
        try {
            this.diretoriaAtual = this.nr.cd(".");
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        this.btnAbrir.setOpaque(true);
        this.btnAtualizar.setOpaque(true);
        this.btnDelFicheiro.setOpaque(true);
        this.btnDelPasta.setOpaque(true);
        this.btnNovaPasta.setOpaque(true);
        this.btnNovoFicheiro.setOpaque(true);
        this.btnSalvar.setOpaque(true);
        this.btnVoltar.setOpaque(true);

        this.extensoesEditaveis = new String[]{"txt", "json", "py", "java", "sql", "md", "sh", "conf", "php", "html", "css", "js"};
        this.txtEditarDefault = "Selecione um dos seguintes ficheiros para editar:\n" + Arrays.toString(this.extensoesEditaveis);
        this.mudarDiretoria(this.diretoriaAtual);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        txtDiretoria = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        listPanel = new javax.swing.JScrollPane();
        DefaultListModel<String> model = new DefaultListModel<>();
        listFicheiros = new javax.swing.JList<>(model);
        btnAtualizar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnDelPasta = new javax.swing.JButton();
        btnDelFicheiro = new javax.swing.JButton();
        txtTamanho = new javax.swing.JTextField();
        editarPanel = new javax.swing.JScrollPane();
        txtEditar = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnNovaPasta = new javax.swing.JButton();
        btnNovoFicheiro = new javax.swing.JButton();
        txtTipo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(158, 158, 158));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        txtDiretoria.setEditable(false);
        txtDiretoria.setBackground(new java.awt.Color(255, 255, 255));
        txtDiretoria.setForeground(new java.awt.Color(38, 50, 56));

        btnVoltar.setBackground(new java.awt.Color(0, 176, 255));
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setPreferredSize(new java.awt.Dimension(100, 27));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        listPanel.setBackground(new java.awt.Color(255, 255, 255));

        listFicheiros.setForeground(new java.awt.Color(38, 50, 56));
        listFicheiros.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFicheirosValueChanged(evt);
            }
        });
        listPanel.setViewportView(listFicheiros);

        btnAtualizar.setBackground(new java.awt.Color(0, 176, 255));
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setBorderPainted(false);
        btnAtualizar.setPreferredSize(new java.awt.Dimension(100, 27));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnAbrir.setBackground(new java.awt.Color(0, 176, 255));
        btnAbrir.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrir.setText("Abrir Pasta");
        btnAbrir.setBorderPainted(false);
        btnAbrir.setEnabled(false);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnDelPasta.setBackground(new java.awt.Color(213, 0, 0));
        btnDelPasta.setForeground(new java.awt.Color(255, 255, 255));
        btnDelPasta.setText("Deletar Pasta");
        btnDelPasta.setBorderPainted(false);
        btnDelPasta.setEnabled(false);
        btnDelPasta.setPreferredSize(new java.awt.Dimension(129, 27));
        btnDelPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelPastaActionPerformed(evt);
            }
        });

        btnDelFicheiro.setBackground(new java.awt.Color(213, 0, 0));
        btnDelFicheiro.setForeground(new java.awt.Color(255, 255, 255));
        btnDelFicheiro.setText("Deletar Ficheiro");
        btnDelFicheiro.setBorderPainted(false);
        btnDelFicheiro.setEnabled(false);
        btnDelFicheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelFicheiroActionPerformed(evt);
            }
        });

        txtTamanho.setEditable(false);
        txtTamanho.setBackground(new java.awt.Color(255, 255, 255));
        txtTamanho.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTamanho.setForeground(new java.awt.Color(38, 50, 56));

        txtEditar.setColumns(20);
        txtEditar.setForeground(new java.awt.Color(38, 50, 56));
        txtEditar.setRows(5);
        txtEditar.setEnabled(false);
        editarPanel.setViewportView(txtEditar);

        btnSalvar.setBackground(new java.awt.Color(100, 221, 23));
        btnSalvar.setForeground(new java.awt.Color(0, 0, 0));
        btnSalvar.setText("Salvar");
        btnSalvar.setBorderPainted(false);
        btnSalvar.setEnabled(false);
        btnSalvar.setPreferredSize(new java.awt.Dimension(100, 27));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnNovaPasta.setBackground(new java.awt.Color(38, 50, 56));
        btnNovaPasta.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaPasta.setText("Nova Pasta");
        btnNovaPasta.setBorderPainted(false);
        btnNovaPasta.setPreferredSize(new java.awt.Dimension(116, 27));
        btnNovaPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPastaActionPerformed(evt);
            }
        });

        btnNovoFicheiro.setBackground(new java.awt.Color(38, 50, 56));
        btnNovoFicheiro.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoFicheiro.setText("Novo Ficheiro");
        btnNovoFicheiro.setBorderPainted(false);
        btnNovoFicheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFicheiroActionPerformed(evt);
            }
        });

        txtTipo.setEditable(false);
        txtTipo.setBackground(new java.awt.Color(255, 255, 255));
        txtTipo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtTipo.setForeground(new java.awt.Color(38, 50, 56));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(txtDiretoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(btnNovoFicheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNovaPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(editarPanel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtTamanho, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAtualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addComponent(btnAbrir)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnDelPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnDelFicheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(txtTipo))))
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiretoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAbrir)
                            .addComponent(btnDelPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelFicheiro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(listPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovaPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoFicheiro))
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        try {
            String nova = this.nr.cd("..");
            if (!nova.equals("")) {
                this.mudarDiretoria(nova);
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void listFicheirosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFicheirosValueChanged
        if (!evt.getValueIsAdjusting() && this.listFicheiros.getSelectedValue() != null) {
            try {
                String nome = this.listFicheiros.getSelectedValue();
                String informacao = this.nr.file(nome);
                if (informacao.startsWith("Dir")) {
                    this.pastaSelecionada();
                } else {
                    this.ficheiroSelecionado(informacao, nome);
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

    }//GEN-LAST:event_listFicheirosValueChanged

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        try {
            String novo = this.nr.cd(this.listFicheiros.getSelectedValue());
            if (!novo.equals("")) {
                this.mudarDiretoria(novo);
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnDelFicheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelFicheiroActionPerformed
        String nome = this.listFicheiros.getSelectedValue();
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar esta operação?\nDeletar " + nome, "Deletar " + nome, JOptionPane.YES_NO_OPTION) == 1) {
            return;
        }
        try {
            if (this.nr.rm(this.listFicheiros.getSelectedValue())) {
                this.mudarDiretoria(this.diretoriaAtual);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível deletar " + nome);
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnDelFicheiroActionPerformed

    private void btnDelPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelPastaActionPerformed
        String nome = this.listFicheiros.getSelectedValue();
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar esta operação?\nDeletar " + nome, "Deletar " + nome, JOptionPane.YES_NO_OPTION) == 1) {
            return;
        }
        try {
            if (this.nr.rmdir(this.listFicheiros.getSelectedValue())) {
                this.mudarDiretoria(this.diretoriaAtual);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível deletar " + nome);
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnDelPastaActionPerformed

    private void btnNovoFicheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFicheiroActionPerformed
        String nome = JOptionPane.showInputDialog(null, "Nome do novo ficheiro");
        if (nome == null) {
            return;
        }

        try {
            if (this.nr.touch(nome)) {
                this.mudarDiretoria(this.diretoriaAtual);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível criar " + nome);
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnNovoFicheiroActionPerformed

    private void btnNovaPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPastaActionPerformed
        String nome = JOptionPane.showInputDialog(null, "Nome da nova pasta");
        if (nome == null) {
            return;
        }

        try {
            if (this.nr.mkdir(nome)) {
                this.mudarDiretoria(this.diretoriaAtual);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível criar " + nome);
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnNovaPastaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = this.listFicheiros.getSelectedValue();
        try {
            if (this.nr.write(nome, this.txtEditar.getText())) {
                this.mudarDiretoria(this.diretoriaAtual);
                JOptionPane.showMessageDialog(null, nome + " Salvo com sucesso!");
            } else {
                this.mudarDiretoria(this.diretoriaAtual);
                JOptionPane.showMessageDialog(null, "Não foi possível salvar " + nome);
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        this.mudarDiretoria(this.diretoriaAtual);
    }//GEN-LAST:event_btnAtualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDelFicheiro;
    private javax.swing.JButton btnDelPasta;
    private javax.swing.JButton btnNovaPasta;
    private javax.swing.JButton btnNovoFicheiro;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane editarPanel;
    private javax.swing.JList<String> listFicheiros;
    private javax.swing.JScrollPane listPanel;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtDiretoria;
    private javax.swing.JTextArea txtEditar;
    private javax.swing.JTextField txtTamanho;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

    private void mudarDiretoria(String nova) {
        try {
            String[] ficheiros = this.nr.ls();
            ((DefaultListModel) this.listFicheiros.getModel()).removeAllElements();
            if (ficheiros != null) {
                Arrays.sort(ficheiros);
                for (String ficheiro : ficheiros) {
                    if (!ficheiro.startsWith(".")) {
                        ((DefaultListModel) this.listFicheiros.getModel()).addElement(ficheiro);
                    }
                }
            }
            this.diretoriaAtual = nova;
            this.txtDiretoria.setText(this.diretoriaAtual);
            this.btnAbrir.setEnabled(false);
            this.btnSalvar.setEnabled(false);
            this.btnDelFicheiro.setEnabled(false);
            this.btnDelPasta.setEnabled(false);
            this.txtTamanho.setText("");
            this.txtTipo.setText("");

            this.txtEditar.setText(this.txtEditarDefault);
            this.txtEditar.setEnabled(false);
            this.listFicheiros.requestFocus();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void ficheiroSelecionado(String informacao, String nome) {
        String[] i = informacao.split("\\|");
        this.txtTamanho.setText(i[0]);
        if (i.length > 1) {
            this.txtTipo.setText(i[1]);
        }
        this.btnDelFicheiro.setEnabled(true);

        this.btnAbrir.setEnabled(false);
        this.btnSalvar.setEnabled(false);
        this.btnDelPasta.setEnabled(false);
        this.txtEditar.setEnabled(false);
        this.txtEditar.setText(this.txtEditarDefault);

        String[] sp = nome.split("\\.");
        if (sp.length <= 1) {
            return;
        }

        for (String extensao : this.extensoesEditaveis) {
            if (extensao.equals(sp[sp.length - 1])) {
                try {
                    this.txtEditar.setText(this.nr.cat(nome));
                    this.btnSalvar.setEnabled(true);
                    this.txtEditar.setEnabled(true);
                    this.txtEditar.setCaretPosition(0);
                    this.txtEditar.requestFocus();
                } catch (RemoteException ex) {
                }
            }
        }
    }

    private void pastaSelecionada() {
        this.btnAbrir.setEnabled(true);
        this.btnDelPasta.setEnabled(true);

        this.btnSalvar.setEnabled(false);
        this.btnDelFicheiro.setEnabled(false);
        this.txtEditar.setEnabled(false);
        this.txtEditar.setText(this.txtEditarDefault);
        this.txtTamanho.setText("");
        this.txtTipo.setText("");
    }

}
