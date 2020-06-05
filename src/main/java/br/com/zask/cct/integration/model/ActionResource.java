package br.com.zask.cct.integration.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActionResource {

    private RefreshMetadataResource refreshMetadata;

    private ExtractSourceResource extractSource;

}
