from django.db import models

# Create your models here.

class Accommodation(models.Model):
    name = models.CharField(max_length=255)
    address = models.CharField(max_length=255)
    description = models.TextField()
    #adicionar mais campos á medida que são necessários

    def __str__(self):
        return self.name

class Restaurant(models.Model):
    name = models.CharField(max_length=255)
    address = models.CharField(max_length=255)
    description = models.TextField()
    #adicionar mais campos á medida que são necessários


    def __str__(self):
        return self.name
