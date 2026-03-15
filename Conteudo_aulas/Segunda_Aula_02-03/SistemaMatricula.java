public class SistemaMatricula {

    public void realizarMatricula(Aluno aluno, Disciplina disciplina) {

        if (!verificarPreRequisitos(aluno, disciplina)) {
            throw new RuntimeException("Pré-requisitos não atendidos");
        }

        if (!verificarVagas(disciplina)) {
            throw new RuntimeException("Sem vagas disponíveis");
        }

        if (disciplina.isEletiva()) {
            aplicarRegrasEletiva(aluno, disciplina);
        }

        if (aluno.isBolsista()) {
            aplicarDesconto(aluno);
        }

        gerarContrato(aluno, disciplina);
        registrarMatriculaBanco(aluno, disciplina);
        enviarEmailConfirmacao(aluno);
        registrarLog(aluno, disciplina);
    }

    private boolean verificarPreRequisitos(Aluno aluno, Disciplina disciplina) {
        // consulta histórico
        return true;
    }

    private boolean verificarVagas(Disciplina disciplina) {
        return true;
    }

    private void aplicarRegrasEletiva(Aluno aluno, Disciplina disciplina) {}

    private void aplicarDesconto(Aluno aluno) {}

    private void gerarContrato(Aluno aluno, Disciplina disciplina) {}

    private void registrarMatriculaBanco(Aluno aluno, Disciplina disciplina) {}

    private void enviarEmailConfirmacao(Aluno aluno) {}

    private void registrarLog(Aluno aluno, Disciplina disciplina) {}
}