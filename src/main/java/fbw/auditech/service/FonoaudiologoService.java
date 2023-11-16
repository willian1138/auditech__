/*package fbw.auditech.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import fbw.auditech.model.IFonoaudiologoRepository;
import fbw.auditech.model.Fonoaudiologo;
import java.util.Optional;
import java.util.List;

@Service
public class FonoaudiologoService implements IFonoaudiologoService{
    
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IFonoaudiologoRepository repositoryF;
    
    public Optional<Fonoaudiologo> cadastrar(Fonoaudiologo fonoaudiologo) {
        logger.info("Serviço de cadastro de fonoaudiologo iniciado");
        return Optional.ofNullable(repositoryF.save(fonoaudiologo));
    }

    public Optional<Fonoaudiologo> consultarPorId(String id) {
        logger.info("Serviço de consulta de fonoaudiologo por ID iniciado");
        Optional<Fonoaudiologo> fonoaudiologo = repositoryF.findById(Long.parseLong(id));
        if (fonoaudiologo.isPresent()) {
            return fonoaudiologo;
        } else {
            throw new ResourceNotFoundException("Fonoaudiologo não encontrado para o ID '" + id + "'");
        }
    }
    public Optional<Fonoaudiologo> consultarPorCpf(String cpf) {
        logger.info("Serviço de consulta de fonoaudiologo por CPF iniciado");
        Optional<Fonoaudiologo> fonoaudiologo = repositoryF.findByCpf(cpf);
        if (fonoaudiologo.isPresent()) {
            return fonoaudiologo;
        } else {
            throw new ResourceNotFoundException("Fonoaudiologo não encontrado para o CPF '" + cpf + "'");
        }
    }
    public Optional<Fonoaudiologo> atualizar(Long id, Fonoaudiologo fonoaudiologo) {
        logger.info("Serviço de atualização de fonoaudiologo iniciado");
        Optional<Fonoaudiologo> fonoaudiologoAtual = repositoryF.findById(id);
        if (fonoaudiologoAtual.isPresent()) {
            fonoaudiologo.setId(id);//cpnverter long para string
            return Optional.ofNullable(repositoryF.save(fonoaudiologo));
        } else {
            throw new ResourceNotFoundException("Fonoaudiologo não encontrado para o ID '" + id + "'");
        }
    public void excluir(Long id) {
        logger.info("Serviço de exclusão de fonoaudiologo iniciado");
        Optional<Fonoaudiologo> fonoaudiologo = repositoryF.findById(id);
        if (fonoaudiologo.isPresent()) {
            repositoryF.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Fonoaudiologo não encontrado para o ID '" + id + "'");
        }
    public void excluirPorCpf(String cpf) {
        logger.info("Serviço de exclusão de fonoaudiologo por CPF iniciado");
        Optional<Fonoaudiologo> fonoaudiologo = repositoryF.findByCpf(cpf);
        if (fonoaudiologo.isPresent()) {
            repositoryF.deleteByCpf(cpf);
        } else {
            throw new ResourceNotFoundException("Fonoaudiologo não encontrado para o CPF '" + cpf + "'");
        }
    public Optional<Fonoaudiologo> login(String cpf, String senha) {
        logger.info("Serviço de login de fonoaudiologo iniciado");
        Optional<Fonoaudiologo> fonoaudiologo = repositoryF.findByCpf(cpf);
        if (fonoaudiologo.isPresent()) {
            if (fonoaudiologo.get().getSenha().equals(senha)) {
                return fonoaudiologo;
            } else {
                throw new ResourceNotFoundException("Senha incorreta");
            }
        } else {
            throw new ResourceNotFoundException("Fonoaudiologo não encontrado para o CPF '" + cpf + "'");
    }}}
//esta ocorrendo erro nos meus metodos personalizados de consulta, não sei o que fazer
//pesquisar o que fazer no typemismatch para optional ao buscar por Cpf(consulta personalizada)

*/