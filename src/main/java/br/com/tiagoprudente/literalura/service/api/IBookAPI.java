package br.com.tiagoprudente.literalura.service.api;

import br.com.tiagoprudente.literalura.service.api.dto.BookData;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface IBookAPI {

    public BookData execute(HashMap<String, String> params);
}
