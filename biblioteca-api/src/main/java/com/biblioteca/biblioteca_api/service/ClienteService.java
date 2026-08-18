package com.biblioteca.biblioteca_api.service;

import com.biblioteca.biblioteca_api.dto.ClienteDTO;
import com.biblioteca.biblioteca_api.entity.Cliente;
import com.biblioteca.biblioteca_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> buscarTodos() {
        return clienteRepository.findAll().stream()
                .map(ClienteDTO::new)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return new ClienteDTO(cliente);
    }

    public ClienteDTO salvar(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        cliente.setAtivo(true);

        cliente = clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }
}