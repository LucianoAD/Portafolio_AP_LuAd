document.addEventListener('DOMContentLoaded', function(){
    
  
const $fragment = document.createDocumentFragment();

const projects_data = [{

    name: "In silico drug repositioning in cancer treatment",
    technologies: "R",
    description: "In silico drug repositioning consists of analyzing large amounts of gene expression data from tumors to identify genetic profiles that can be used to locate tumor-reversing drugs in large databases.",
    url: "assets/docs/LucianoAnselmino-tesis.pdf"
},
{
    name: "Bioremediation of coastal environments",
    technologies: "R",
    description: "Different bioinformatic tools were used to analyze metagenomes of coastal environments in order to identify by sequence similarity enzymes with high degradative capacity of alginates, the main component of brown algae.",
    url: "https://ri.conicet.gov.ar/bitstream/handle/11336/36758/CONICET_Digital_Nro.364c89aa-8c76-457c-abcb-1290b06a4562_A.pdf?sequence=2&isAllowed=y"
},
{
    name: "MyWebPortafolio",
    technologies: "HTML - CSS - JavaScript - Node.js",
    description: "In this project, different tools learned in Argentina Programa training were used to develop a personal presentation web portfolio.",
    url: ""
}]

const $project_list_div = document.getElementById("project-list")

projects_data.forEach(project => {
    const $div = document.createElement("div")
    $div.classList.add("project-info")
    const $h3 = document.createElement("h3")
    $h3.innerHTML = project["name"]
    const $h4 = document.createElement("h4")
    $h4.textContent = project["technologies"]
    const $p = document.createElement("p")
    $p.textContent = project["description"]
    const $a = document.createElement("a")
    $a.classList.add("light-btn")
    $a.href = project["url"]
    $a.target = "_blank"
    $a.textContent = "More..."
    
    $div.appendChild($h3)
    $div.appendChild($h4)
    $div.appendChild($p)
    $div.appendChild($a)
    $fragment.appendChild($div)
})

$project_list_div.appendChild($fragment)


});

document.addEventListener("DOMContentLoaded", function (event) {
    var scrollpos = localStorage.getItem("scrollpos");
    if (scrollpos) window.scrollTo(0, scrollpos);
  });

  window.onscroll = function (e) {
    localStorage.setItem("scrollpos", window.scrollY);
  };

