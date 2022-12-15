package sample;


import java.awt.*;

public interface Enums {
    double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width*0.6;
    double screenHeight= Toolkit.getDefaultToolkit().getScreenSize().width*0.6*(2/3.0);
    javafx.scene.text.Font font = new javafx.scene.text.Font("OCR A Extended",12);
    String encSym = "~";

    /**<b>
     * <code>color[0]</code> = text color;</b><br><div style="border:1px solid black;width:40px;height:20px;background-color:#ffffff;float:right;margin: 0 10px 0 0"></div><br>
     * <b>
     * <code>color[1]</code> = TableData Interface color;</b><br><div style="border:1px solid black;width:40px;height:20px;background-color:#950740;float:right;margin: 0 10px 0 0"></div><br>
     * <b>
     * <code>color[2]</code> = yoCodeUI color;</b><br><div style="border:1px solid black;width:40px;height:20px;background-color:#c3073f;float:right;margin: 0 10px 0 0"></div><br>
     * <b>
     * <code>color[3]</code> = logoPath color;</b><br><div style="border:1px solid black;width:40px;height:20px;background-color:#6f2232;float:right;margin: 0 10px 0 0"></div><br>
     * <b>
     * <code>color[4]</code> = background;</b><br><div style="border:1px solid black;width:40px;height:20px;background-color:#1a1a1d;float:right;margin: 0 10px 0 0"></div><br>
     * <b>
     * <code>color[5]</code> = The new GUI background</b><div style="border:1px solid black;width:40px;height:20px;background-color:#222229;float:right;margin: 0 10px 0 0"></div><br>
     *
     * */
    javafx.scene.paint.Color[] colors = {
            javafx.scene.paint.Color.valueOf("#ffffff"),
            javafx.scene.paint.Color.valueOf("#950740"),
            javafx.scene.paint.Color.valueOf("#c3073f"),
            javafx.scene.paint.Color.valueOf("#6f2232"),
            javafx.scene.paint.Color.valueOf("#1a1a1d"),
            javafx.scene.paint.Color.valueOf("#222229")};

    String[] comments = {
            "All lettres .",
            "Select number from 0 to 25 .",
            "Letters, Numbers, Comma and Dot Only.",
            "Dots and Dashes and each two letters adjacent to each other\n must be separated by one space and each two words adjacent \nto each other must be separated by three spaces\n /n And for space write \"_\"",
            "Letters only",
            "All 26 english letters only.",
            "All letters without new line (ENTER) .",
            "Not more than 8 characters ."
    };

    String before = "<script>\n";
    String pathOfXML = "recentz.html";
    String after = "\n" +
            "</script>\n" +
            "<style>\n" +
            "        body{\n" +
            "            background: #1a1a1d;\n" +
            "        }\n" +
            "        @font-face{\n" +
            "            font-family:comfortaa;\n" +
            "            src:url(sample/style/Comfortaa.ttf);\n" +
            "        }\n" +
            "        *{\n" +
            "            box-sizing: border-box;\n" +
            "            white-space: normal;\n" +
            "            word-break: break-all;\n" +
            "            font-family: comfortaa;\n" +
            "        }\n" +
            "        #lala{\n" +
            "            position:relative;\n" +
            "            width:100%;\n" +
            "            height:100%;\n" +
            "            line-height:23vw;\n" +
            "            margin-top:-20%;\n" +
            "        }\n" +
            "        .alerta{\n" +
            "            position:fixed;\n" +
            "            z-index:999;\n" +
            "    \t\t\t\t\t\t width:85vw;\n" +
            "            height:0;\n" +
            "            transition:all 0.5s ease-in-out;\n" +
            "            display:flex;\n" +
            "            bottom:5vh;\n" +
            "            opacity:0;\n" +
            "            visibility:hidden;\n" +
            "            background-color:#5a0960;\n" +
            "            justify-content:center;\n" +
            "            align-items:center;\n" +
            "            color:white;\n" +
            "            font-size:0;\n" +
            "            border-radius:3vw;\n" +
            "            left:7.5vw;\n" +
            "            right:7.5vw\n" +
            "        }\n" +
            "\n" +
            "        body::-WebKit-scrollbar{background-color: #1a1a1d;\n" +
            "        }\n" +
            "\n" +
            "        body::-WebKit-scrollbar-thumb{background-color: #222229}\n" +
            "\n" +
            "\n" +
            "\n" +
            "    </style>\n" +
            "<input type=\"hidden\" value=\"*::-WebKit-scrollbar{width:0;background: transparent;display:none;}\">\n" +
            "<input id='popo' style='position: absolute; left:-10000%'>\n" +
            "<div id='lala'></div>\n" +
            "<div class='alerta' id='text'><div>text copied!</div></div>\n" +
            "<div class='alerta' id='key'><div>cipher key copied!</div></div>\n" +
            "<div class='alerta' id='nokey'><div>this cipher has no key!</div></div>\n" +
            "<script>\n" +
            "\n" +
            "\n" +
            "    window.onerror = function(error, url, line){\n" +
            "            alert(\"ERR: \" + error + \"\\n\\nIn file:\" + url + \"\\n\\nIn line:\" + line);\n" +
            "           return true;\n" +
            "     }\n" +
            "\n" +
            "     /*var firstScript = document.getElementsByTagName('script')[0],\n" +
            "     js = document.createElement('script');\n" +
            "     js.src = 'XMLRequest.js';\n" +
            "     js.onload = function () {}*/\n" +
            "\n" +
            "    //keys, texts, ciphers, projects\n" +
            "\t\tvar kka = keys.split(\"" + encSym + "\");\n" +
            "\t\tvar tta = texts.split(\"" + encSym + "\");\n" +
            "\t\tvar cca = ciphers.split(\"" + encSym + "\");\n" +
            "\t\tvar ppa = projects.split(\"" + encSym + "\");\n" +
            "\n" +
            "        var keyss = [];\n" +
            "\n" +
            "        for(let i = 0;i<kka.length;i++){\n" +
            "            if(kka[i].length > 16&&kka[i]!=\"this cipher has no key\"){\n" +
            "                keyss[i] = kka[i].substr(0, 15) + \"...\";\n" +
            "            }else{\n" +
            "                keyss[i] = kka[i];\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "        var lalaLongs = kka.length;\n" +
            "\n" +
            "\n" +
            "\n" +
            "        var peepee = 0;\n" +
            "\n" +
            "        function lala(p, text, cipher, key, keyy){\n" +
            "            var brrr = document.createElement('BR');\n" +
            "            peepee++;\n" +
            "            var lala = document.getElementById('lala');\n" +
            "            var diva = document.createElement('DIV');\n" +
            "            var divd = document.createElement('DIV');\n" +
            "            var divtooltip = document.createElement('DIV');\n" +
            "            divtooltip.class = 'lololo';\n" +
            "            var divruprup = document.createElement('DIV');\n" +
            "            divruprup.class = 'ruprup';\n" +
            "            var divtooltiptext = document.createElement('DIV');\n" +
            "            divtooltiptext.innerHTML = cipher + ', <br>' + key;\n" +
            "            divtooltip.innerHTML = '!';\n" +
            "            divruprup.innerHTML = text;\n" +
            "            divd.innerHTML = p;\n" +
            "            diva.appendChild(divd);\n" +
            "            diva.appendChild(divruprup);\n" +
            "            diva.appendChild(divtooltip);\n" +
            "            diva.style.cssText = \"width:30%;height:18vw;position:absolute;display: block;background: #c3073f;font-size: calc(100vw / 49);color:white;font-weight:bolder;text-align: center;border-radius: calc(100vw / 30);padding: 5%;padding-top: 6%;\";\n" +
            "\n" +
            "\n" +
            "\n" +
            "            divd.style.cssText = \"width:60%;display: block;position:absolute;top:-7%;height:30%;background: #5009a0;/*950740*/border-radius: calc(100vw / 50);z-index: 2;left:-3.125%;text-align:center;vertical-align:middle;line-height:250%;\";\n" +
            "            divruprup.style.cssText = \"width:100%;height:100%;overflow-y:auto;-ms-overflow-style:none;scrollbar-width:none;z-index:3;line-height:110%;\";\n" +
            "\n" +
            "           divruprup.onclick = function(){\n" +
            "                var gg = document.getElementById('popo');\n" +
            "                gg.value = text;\n" +
            "                var copyText = gg;\n" +
            "                copyText.select();\n" +
            "                copyText.setSelectionRange(0, 99999);//for mobile devices\n" +
            "                document.execCommand(\"COPY\");\n" +
            "                alerttext();\n" +
            "           }\n" +
            "\n" +
            "\n" +
            "           lala.appendChild(divtooltiptext);\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "            divtooltip.style.cssText = \"position: absolute;color:white;width:3vw;height:3vw;background: #6f2232;border-radius: 100%;line-height: 3vw;right:5%;bottom:6%;font-size:calc(100vw / 60);\";\n" +
            "\n" +
            "            divtooltiptext.style.cssText = \"background-color: #4e4e50;color: #fff;text-align: center;position: fixed;z-index: 999;transition:all 0.3s ease-out; width:30%;height:8vw; font-size:2vw;border-bottom-left-radius:2vw;border-bottom-right-radius:2vw;line-height:3.5vw;\";\n" +
            "\n" +
            "             divtooltiptext.style.left = 'calc(3.25% + 30% + 1.6666%)';\n" +
            "\n" +
            "             divtooltiptext.style.top = '-8vw';\n" +
            "\n" +
            "            if(peepee==1){\n" +
            "                lala.appendChild(brrr);\n" +
            "                diva.style.left = \"3.3333%\";\n" +
            "            }else if(peepee==2){\n" +
            "                diva.style.left = \"calc(3.3333% + 30% + 1.6666%)\";\n" +
            "            }else if(peepee==3){\n" +
            "                diva.style.left = \"calc(3.3333% + 30% + 1.6666% + 30% + 1.6666%)\";\n" +
            "                peepee = 0;\n" +
            "            }\n" +
            "\n" +
            "            divtooltip.onmouseover = function(){\n" +
            "\n" +
            "                divtooltiptext.style.top = '0vw';\n" +
            "\n" +
            "            }\n" +
            "            divtooltip.onmouseout = function(){\n" +
            "\n" +
            "                divtooltiptext.style.top = '-8vw';\n" +
            "\n" +
            "            }\n" +
            "\n" +
            "            divtooltip.onclick = function() {\n" +
            "                var gg = document.getElementById('popo');\n" +
            "                gg.value = keyy;\n" +
            "                var copyText = gg;\n" +
            "                copyText.select();\n" +
            "                copyText.setSelectionRange(0, 99999);//for mobile devices\n" +
            "                if(keyy!='this cipher has no key'){\n" +
            "                    document.execCommand(\"COPY\");\n" +
            "                    alertkey();\n" +
            "                }else{\n" +
            "                    alertnokey();\n" +
            "                }\n" +
            "\n" +
            "            }\n" +
            "\n" +
            "\n" +
            "           lala.appendChild(diva);\n" +
            "\n" +
            "\n" +
            "\n" +
            "        }\n" +
            "        for(var i = 0;i<lalaLongs;i++){\n" +
            "            lala(ppa[i], tta[i], cca[i], keyss[i], kka[i]);\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "        function alerttext(){\n" +
            "            var textaa = document.getElementById(\"text\");\n" +
            "            textaa.style.height = \"20vh\";\n" +
            "            textaa.style.visibility = 'visible';\n" +
            "            textaa.style.opacity = 1;\n" +
            "            textaa.style.fontSize = 'calc(2vw + 2vh)';\n" +
            "\n" +
            "            setTimeout(function(){\n" +
            "                textaa.style.height = 0;\n" +
            "                textaa.style.fontSize = 0;\n" +
            "                textaa.style.visibility = 'hidden';\n" +
            "                textaa.style.opacity = 0;\n" +
            "            }, 2000);\n" +
            "        }\n" +
            "        function alertkey(){\n" +
            "            var keyaa = document.getElementById(\"key\");\n" +
            "            keyaa.style.height = \"20vh\";\n" +
            "            keyaa.style.visibility = 'visible';\n" +
            "            keyaa.style.opacity = 1;\n" +
            "            keyaa.style.fontSize = 'calc(2vw + 2vh)';\n" +
            "\n" +
            "            setTimeout(function(){\n" +
            "                keyaa.style.height = 0;\n" +
            "                keyaa.style.visibility = 'hidden';\n" +
            "                keyaa.style.opacity = 0;\n" +
            "                keyaa.style.fontSize = 0;\n" +
            "            }, 2000);\n" +
            "        }\n" +
            "        function alertnokey(){\n" +
            "            var keyaa = document.getElementById(\"nokey\");\n" +
            "            keyaa.style.height = \"20vh\";\n" +
            "            keyaa.style.visibility = 'visible';\n" +
            "            keyaa.style.opacity = 1;\n" +
            "            keyaa.style.fontSize = 'calc(2vw + 2vh)';\n" +
            "\n" +
            "            setTimeout(function(){\n" +
            "                keyaa.style.height = 0;\n" +
            "                keyaa.style.visibility = 'hidden';\n" +
            "                keyaa.style.opacity = 0;\n" +
            "                keyaa.style.fontSize = 0;\n" +
            "            }, 2000);\n" +
            "        };\n" +
            "     /*firstScript.parentNode.insertBefore(js, firstScript);*/\n" +
            "    </script>";

    String allText = "<script>\n" +
            "var texts = \"Error File Not Found~Warning~Please do not edit this file~Generating new file~Done~Enjoy Using yoCode\";var projects = \"ERROR~WARNING~INFO~INFO~INFO~INFO\";var ciphers = \"Vigenere Cipher~Momoalphabetic~Morse Code~Vigenere Cipher~Momoalphabetic~Morse Code~Morse Code~ \";var keys = \"abcdefghijklmnopqrstuvwxyz~this cipher has no key~abcdefghijklmnopqrstuvwxyz~this cipher has no key~000~0\";\n" +
            "</script>\n" +
            "<style>\n" +
            "        body{\n" +
            "            background: #1a1a1d;\n" +
            "        }\n" +
            "        @font-face{\n" +
            "            font-family:comfortaa;\n" +
            "            src:url(sample/style/Comfortaa.ttf);\n" +
            "        }\n" +
            "        *{\n" +
            "            box-sizing: border-box;\n" +
            "            white-space: normal;\n" +
            "            word-break: break-all;\n" +
            "            font-family: comfortaa;\n" +
            "        }\n" +
            "        #lala{\n" +
            "            position:relative;\n" +
            "            width:100%;\n" +
            "            height:100%;\n" +
            "            line-height:23vw;\n" +
            "            margin-top:-20%;\n" +
            "        }\n" +
            "        .alerta{\n" +
            "            position:fixed;\n" +
            "            z-index:999;\n" +
            "    \t\t\t\t\t\t width:85vw;\n" +
            "            height:0;\n" +
            "            transition:all 0.5s ease-in-out;\n" +
            "            display:flex;\n" +
            "            bottom:5vh;\n" +
            "            opacity:0;\n" +
            "            visibility:hidden;\n" +
            "            background-color:#5a0960;\n" +
            "            justify-content:center;\n" +
            "            align-items:center;\n" +
            "            color:white;\n" +
            "            font-size:0;\n" +
            "            border-radius:3vw;\n" +
            "            left:7.5vw;\n" +
            "            right:7.5vw\n" +
            "        }\n" +
            "\n" +
            "        body::-WebKit-scrollbar{background-color: #1a1a1d;\n" +
            "        }\n" +
            "\n" +
            "        body::-WebKit-scrollbar-thumb{background-color: #222229}\n" +
            "\n" +
            "\n" +
            "\n" +
            "    </style>\n" +
            "<input type=\"hidden\" value=\"*::-WebKit-scrollbar{width:0;background: transparent;display:none;}\">\n" +
            "<input id='popo' style='position: absolute; left:-10000%'>\n" +
            "<div id='lala'></div>\n" +
            "<div class='alerta' id='text'><div>text copied!</div></div>\n" +
            "<div class='alerta' id='key'><div>cipher key copied!</div></div>\n" +
            "<div class='alerta' id='nokey'><div>this cipher has no key!</div></div>\n" +
            "<script>\n" +
            "\n" +
            "\n" +
            "    window.onerror = function(error, url, line){\n" +
            "            alert(\"ERR: \" + error + \"\\n\\nIn file:\" + url + \"\\n\\nIn line:\" + line);\n" +
            "           return true;\n" +
            "     }\n" +
            "\n" +
            "     /*var firstScript = document.getElementsByTagName('script')[0],\n" +
            "     js = document.createElement('script');\n" +
            "     js.src = 'XMLRequest.js';\n" +
            "     js.onload = function () {}*/\n" +
            "\n" +
            "    //keys, texts, ciphers, projects\n" +
            "\t\tvar kka = keys.split(\"~\");\n" +
            "\t\tvar tta = texts.split(\"~\");\n" +
            "\t\tvar cca = ciphers.split(\"~\");\n" +
            "\t\tvar ppa = projects.split(\"~\");\n" +
            "\n" +
            "        var keyss = [];\n" +
            "\n" +
            "        for(let i = 0;i<kka.length;i++){\n" +
            "            if(kka[i].length > 16&&kka[i]!=\"this cipher has no key\"){\n" +
            "                keyss[i] = kka[i].substr(0, 15) + \"...\";\n" +
            "            }else{\n" +
            "                keyss[i] = kka[i];\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "        var lalaLongs = kka.length;\n" +
            "\n" +
            "\n" +
            "\n" +
            "        var peepee = 0;\n" +
            "\n" +
            "        function lala(p, text, cipher, key, keyy){\n" +
            "            var brrr = document.createElement('BR');\n" +
            "            peepee++;\n" +
            "            var lala = document.getElementById('lala');\n" +
            "            var diva = document.createElement('DIV');\n" +
            "            var divd = document.createElement('DIV');\n" +
            "            var divtooltip = document.createElement('DIV');\n" +
            "            divtooltip.class = 'lololo';\n" +
            "            var divruprup = document.createElement('DIV');\n" +
            "            divruprup.class = 'ruprup';\n" +
            "            var divtooltiptext = document.createElement('DIV');\n" +
            "            divtooltiptext.innerHTML = cipher + ', <br>' + key;\n" +
            "            divtooltip.innerHTML = '!';\n" +
            "            divruprup.innerHTML = text;\n" +
            "            divd.innerHTML = p;\n" +
            "            diva.appendChild(divd);\n" +
            "            diva.appendChild(divruprup);\n" +
            "            diva.appendChild(divtooltip);\n" +
            "            diva.style.cssText = \"width:30%;height:18vw;position:absolute;display: block;background: #c3073f;font-size: calc(100vw / 49);color:white;font-weight:bolder;text-align: center;border-radius: calc(100vw / 30);padding: 5%;padding-top: 6%;\";\n" +
            "\n" +
            "\n" +
            "\n" +
            "            divd.style.cssText = \"width:60%;display: block;position:absolute;top:-7%;height:30%;background: #5009a0;/*950740*/border-radius: calc(100vw / 50);z-index: 2;left:-3.125%;text-align:center;vertical-align:middle;line-height:250%;\";\n" +
            "            divruprup.style.cssText = \"width:100%;height:100%;overflow-y:auto;-ms-overflow-style:none;scrollbar-width:none;z-index:3;line-height:110%;\";\n" +
            "\n" +
            "           divruprup.onclick = function(){\n" +
            "                var gg = document.getElementById('popo');\n" +
            "                gg.value = text;\n" +
            "                var copyText = gg;\n" +
            "                copyText.select();\n" +
            "                copyText.setSelectionRange(0, 99999);//for mobile devices\n" +
            "                document.execCommand(\"COPY\");\n" +
            "                alerttext();\n" +
            "           }\n" +
            "\n" +
            "\n" +
            "           lala.appendChild(divtooltiptext);\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "            divtooltip.style.cssText = \"position: absolute;color:white;width:3vw;height:3vw;background: #6f2232;border-radius: 100%;line-height: 3vw;right:5%;bottom:6%;font-size:calc(100vw / 60);\";\n" +
            "\n" +
            "            divtooltiptext.style.cssText = \"background-color: #4e4e50;color: #fff;text-align: center;position: fixed;z-index: 999;transition:all 0.3s ease-out; width:30%;height:8vw; font-size:2vw;border-bottom-left-radius:2vw;border-bottom-right-radius:2vw;line-height:3.5vw;\";\n" +
            "\n" +
            "             divtooltiptext.style.left = 'calc(3.25% + 30% + 1.6666%)';\n" +
            "\n" +
            "             divtooltiptext.style.top = '-8vw';\n" +
            "\n" +
            "            if(peepee==1){\n" +
            "                lala.appendChild(brrr);\n" +
            "                diva.style.left = \"3.3333%\";\n" +
            "            }else if(peepee==2){\n" +
            "                diva.style.left = \"calc(3.3333% + 30% + 1.6666%)\";\n" +
            "            }else if(peepee==3){\n" +
            "                diva.style.left = \"calc(3.3333% + 30% + 1.6666% + 30% + 1.6666%)\";\n" +
            "                peepee = 0;\n" +
            "            }\n" +
            "\n" +
            "            divtooltip.onmouseover = function(){\n" +
            "\n" +
            "                divtooltiptext.style.top = '0vw';\n" +
            "\n" +
            "            }\n" +
            "            divtooltip.onmouseout = function(){\n" +
            "\n" +
            "                divtooltiptext.style.top = '-8vw';\n" +
            "\n" +
            "            }\n" +
            "\n" +
            "            divtooltip.onclick = function() {\n" +
            "                var gg = document.getElementById('popo');\n" +
            "                gg.value = keyy;\n" +
            "                var copyText = gg;\n" +
            "                copyText.select();\n" +
            "                copyText.setSelectionRange(0, 99999);//for mobile devices\n" +
            "                if(keyy!='this cipher has no key'){\n" +
            "                    document.execCommand(\"COPY\");\n" +
            "                    alertkey();\n" +
            "                }else{\n" +
            "                    alertnokey();\n" +
            "                }\n" +
            "\n" +
            "            }\n" +
            "\n" +
            "\n" +
            "           lala.appendChild(diva);\n" +
            "\n" +
            "\n" +
            "\n" +
            "        }\n" +
            "        for(var i = 0;i<lalaLongs;i++){\n" +
            "            lala(ppa[i], tta[i], cca[i], keyss[i], kka[i]);\n" +
            "        }\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "        function alerttext(){\n" +
            "            var textaa = document.getElementById(\"text\");\n" +
            "            textaa.style.height = \"20vh\";\n" +
            "            textaa.style.visibility = 'visible';\n" +
            "            textaa.style.opacity = 1;\n" +
            "            textaa.style.fontSize = 'calc(2vw + 2vh)';\n" +
            "\n" +
            "            setTimeout(function(){\n" +
            "                textaa.style.height = 0;\n" +
            "                textaa.style.fontSize = 0;\n" +
            "                textaa.style.visibility = 'hidden';\n" +
            "                textaa.style.opacity = 0;\n" +
            "            }, 2000);\n" +
            "        }\n" +
            "        function alertkey(){\n" +
            "            var keyaa = document.getElementById(\"key\");\n" +
            "            keyaa.style.height = \"20vh\";\n" +
            "            keyaa.style.visibility = 'visible';\n" +
            "            keyaa.style.opacity = 1;\n" +
            "            keyaa.style.fontSize = 'calc(2vw + 2vh)';\n" +
            "\n" +
            "            setTimeout(function(){\n" +
            "                keyaa.style.height = 0;\n" +
            "                keyaa.style.visibility = 'hidden';\n" +
            "                keyaa.style.opacity = 0;\n" +
            "                keyaa.style.fontSize = 0;\n" +
            "            }, 2000);\n" +
            "        }\n" +
            "        function alertnokey(){\n" +
            "            var keyaa = document.getElementById(\"nokey\");\n" +
            "            keyaa.style.height = \"20vh\";\n" +
            "            keyaa.style.visibility = 'visible';\n" +
            "            keyaa.style.opacity = 1;\n" +
            "            keyaa.style.fontSize = 'calc(2vw + 2vh)';\n" +
            "\n" +
            "            setTimeout(function(){\n" +
            "                keyaa.style.height = 0;\n" +
            "                keyaa.style.visibility = 'hidden';\n" +
            "                keyaa.style.opacity = 0;\n" +
            "                keyaa.style.fontSize = 0;\n" +
            "            }, 2000);\n" +
            "        };\n" +
            "     /*firstScript.parentNode.insertBefore(js, firstScript);*/\n" +
            "    </script>";

}
