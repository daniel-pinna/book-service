package br.dev.pinna.proxy;

import br.dev.pinna.dto.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "exchange-service", url="localhost:8000")
public interface ExchangeProxy {

    @GetMapping(value = "/exchange-service/{amount}/{from}/{to}")
    public Exchange getExchange(@PathVariable("amount") Double amount, @PathVariable("from") String from, @PathVariable("to") String to);
}
