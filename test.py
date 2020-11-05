# -*- coding: utf-8 -*-
import requests, json
from requests.exceptions import ConnectionError
from time import sleep
import random

#  Метод для корректной обработки строк в кодировке UTF-8 как в Python 3, так и в Python 2
import sys

if sys.version_info < (3,):
    def u(x):
        try:
            return x.encode("utf8")
        except UnicodeDecodeError:
            return x
else:
    def u(x):
        if type(x) == type(b''):
            return x.decode('utf8')
        else:
            return x


def send(body, url): 

    CampaignsURL = 'https://api-sandbox.direct.yandex.com/json/v5/' + url

    token = 'AgAAAABH84LTAAasZYthWGp4OkBonisZBLrW3Ls'
    clientLogin = 'aslavkovsky'
    headers = {"Authorization": "Bearer " + token,  # OAuth-токен. Использование слова Bearer обязательно
           "Client-Login": clientLogin,  # Логин клиента рекламного агентства
           "Accept-Language": "ru",  # Язык ответных сообщений
           }


    jsonBody = json.dumps(body, ensure_ascii=False).encode('utf8')

    try:
        result = requests.post(CampaignsURL, jsonBody, headers=headers)
        if result.status_code == 200 or result.json().get("error", False) == False:
            return result
        else: return
    except ConnectionError:
        print("Произошла ошибка соединения с сервером API.")
        return
    except:
        print("Произошла непредвиденная ошибка.")
        return



def get_compains(): 
    body = {"method": "get",  # Используемый метод.
                "params":{
                    "SelectionCriteria": {},  # Критерий отбора кампаний. Для получения всех кампаний должен быть пустым
                    "FieldNames": ["Id", "Name"]  # Имена параметров, которые требуется получить.
                   }
            }
    res = send(body,"campaigns")
    if res != None: 
        ids = []
        for campaign in res.json()["result"]["Campaigns"]:
            ids.append({'name' : campaign['Name'], 'id': campaign['Id']})
            print("Рекламная кампания: {} №{}".format(u(campaign['Name']), campaign['Id']))

        return ids
    else: return

def get_compain_add(compain): 
    body = {"method": "get",  # Используемый метод.
             "params": {
                "SelectionCriteria":{"CampaignIds": [compain['id']]},
                "FieldNames" :["Id","Status"],
                "TextAdFieldNames" : ["Title2"]
               },
            }

    res = send(body, "ads")
    if res != None: 
        ads = [];
        for campaign in res.json()["result"]["Ads"]:
            print("Компания {}: Объявление #{} {} {}".format(compain['name'], u(campaign['Id']), campaign['Status'], campaign['TextAd']['Title2']))
            if campaign['Status'] == 'ACCEPTED': ads.append(campaign['Id'])

        return ads
    else: return


def update_add(id, title2):
    body = {"method": "update",  # Используемый метод.
             "params": {
                    "Ads": [{
                        "Id" : id,
                        "TextAd": {
                            "Title2" : title2
                        }
                    }]
                
                }
            }
    res = send(body, "ads")



ids = get_compains()
rand_text = ['Полетаю на дирижабле – на','Зайду в о там','Отправлюсь в тёмную башню ','На арену – люблю помериться ']

if ids != None: 
    for i in ids:
        ads = get_compain_add(i)
        if ads != None: 
            for ad in ads:
                update_add(ad, rand_text[random.randint(0,3)])

