import os
import comtypes.client

def ppt_to_pdf(input_ppt, output_pdf):
    powerpoint = comtypes.client.CreateObject("PowerPoint.Application")
    powerpoint.Visible = 1  # Make PowerPoint visible (1) or hidden (-1)

    ppt = powerpoint.Presentations.Open(os.path.abspath(input_ppt))
    ppt.SaveAs(os.path.abspath(output_pdf), 32)  # 32 is the PowerPoint PDF format
    ppt.Close()

    powerpoint.Quit()

# Example usage
ppt_to_pdf("Unit 4.pptx", "output.pdf")
