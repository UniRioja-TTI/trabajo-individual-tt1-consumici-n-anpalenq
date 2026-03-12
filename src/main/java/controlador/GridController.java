package controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import servicios.GridService;
import utilidades.client.ApiException;

@Controller
public class GridController {

    private final GridService gridService;

    public GridController(GridService gridService) {
        this.gridService = gridService;
    }

    @GetMapping("/grid")
    public String mostrarGrid(@RequestParam("tok") Integer tok, Model model) {
        try {
            String resultado = gridService.obtenerGrid(tok);
            model.addAttribute("resultado", resultado);
        } catch (ApiException e) {
            model.addAttribute("resultado", "Error llamando al servicio: " + e.getMessage());
        }

        return "grid";
    }
}
