import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.parser.StrictErrorHandler;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProcedureParseTest {

    @Test
    public void parseProcedure() throws IOException {

        String fhirContent = new String(Files.readAllBytes(Paths.get("data\\procedure.json")));
        System.out.println(fhirContent);

        FhirContext ourCtx = FhirContext.forDstu2();
        IParser parser = ourCtx.newJsonParser();
        parser.setParserErrorHandler(new StrictErrorHandler());
        parser.parseResource(fhirContent);
    }

    @Test
    public void parseProcedureInBundle() throws IOException {

        String fhirContent = new String(Files.readAllBytes(Paths.get("data\\procedure-bundle.json")));
        System.out.println(fhirContent);

        FhirContext ourCtx = FhirContext.forDstu2();
        IParser parser = ourCtx.newJsonParser();
        parser.setParserErrorHandler(new StrictErrorHandler());
        parser.parseResource(fhirContent);
    }
}
