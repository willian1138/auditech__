package fbw.auditech.service;

import java.util.Optional;

import fbw.auditech.model.Fonoaudiologo;

public interface IFonoaudiologoService {
    public Optional<Fonoaudiologo> cadastrar(Fonoaudiologo fonoaudiologo);
    public Optional<Fonoaudiologo> consultarPorId(Long id);
    public Optional<Fonoaudiologo> consultarPorCpf(String cpf);
    public Optional<Fonoaudiologo> atualizar(Long id, Fonoaudiologo fonoaudiologo);
    public void excluir(Long id);
    public Optional<Fonoaudiologo> login(String cpf, String senha);
    public void excluirPorCpf(String cpf);
}
