package java.org.exercise.Test;/*
package org.exercise.Test;

import com.generali.leonardo.contract.validation.DenunciaPut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class DenunciaSource {

    @NotBlank(message = "Field \"denunciaIdSource\" cannot be blank", groups = {DenunciaPut.class, Default.class})
    String denunciaIdSource;

    @NotBlank(message = "Field \"sistemaSorgenteId\" cannot be blank", groups = {DenunciaPut.class, Default.class})
    String sistemaSorgenteId;

    public EsitoSigimPlSql updateStatoRimborso(String denunciaId, AggiornaStatoRimborso request) {
        final Denuncia denuncia = denunciaService.getDenunciaById(denunciaId);
        final String denunciaIdSource = Optional.ofNullable(denuncia.getDenunciaSource()).orElseThrow(() -> new UnprocessableEntityException(String.format("Given denuncia with id %s does not have denunciaIdSource", denunciaId, "denunciaId"))).getDenunciaIdSource();
        return denunciaSigimService.aggiornaStatoRimborso(denunciaIdSource, request);
    }


}
*/
