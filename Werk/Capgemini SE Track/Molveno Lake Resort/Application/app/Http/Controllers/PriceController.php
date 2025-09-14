<?php

namespace App\Http\Controllers;

use App\Services\RoomSelectionService;
use Illuminate\Http\Request;

class PriceController extends Controller
{
    private $breakfastRateAdult = 17.5;
    private $breakfastRateChild = 10;
    
    private $stayPrice=0;
    private $formattedStayPrice;
    private $breakfastPriceAdult=0;
    private $formattedBreakfastPriceAdult;
    private $breakfastPriceChild=0;
    private $formattedBreakfastPriceChild;
    private $totalPrice=0;
    private $formattedTotalPrice;

    private $roomSelectionService;

    public function __construct()
    {
        $this->roomSelectionService=new RoomSelectionService();
    }

    private function calculateStayPrice($roomPrice, $duration)
    {
        $this->stayPrice=$roomPrice*$duration;
    }

    private function formatStayPrice($stayPrice){
        if($stayPrice==floor($stayPrice)){
            $this->formattedStayPrice=number_format($stayPrice,0);
        }
        else{
            $this->formattedStayPrice=number_format($stayPrice,2);
        }
    }

    private function calculateBreakfastPriceAdults($adults, $duration) 
    {
        $this->breakfastPriceAdult=$adults*$this->breakfastRateAdult*$duration;
    }

    private function formatBreakfastPriceAdults($breakfastPriceAdult){
        if($breakfastPriceAdult==floor($breakfastPriceAdult)){
            $this->formattedBreakfastPriceAdult=number_format($breakfastPriceAdult,0);
        }
        else{
            $this->formattedBreakfastPriceAdult=number_format($breakfastPriceAdult,2);
        }
    }

    private function calculateBreakfastPriceChildren($children, $duration) 
    {
        $this->breakfastPriceChild=$children*$this->breakfastRateChild*$duration;
    }

    private function formatBreakfastPriceChildren($breakfastPriceChild){
        if($breakfastPriceChild==floor($breakfastPriceChild)){
            $this->formattedBreakfastPriceChild=number_format($breakfastPriceChild,0);
        }
        else{
            $this->formattedBreakfastPriceChild=number_format($breakfastPriceChild,2);
        }
    }

    private function calculateTotalPrice() 
    {
        $this->totalPrice=($this->stayPrice+$this->breakfastPriceAdult+$this->breakfastPriceChild)*100;
    }

    private function formatTotalPrice($totalPrice){
        if($totalPrice==floor($totalPrice)){
            $this->formattedTotalPrice=number_format($totalPrice/100,0);
        }
        else{
            $this->formattedTotalPrice=number_format($totalPrice/100,2);
        }
    }

    public function calculatePrices($roomPrice, $duration, $adults, $children)
    {
        $this->calculateStayPrice($roomPrice, $duration);
        $this->calculateBreakfastPriceAdults($adults, $duration);
        $this->calculateBreakfastPriceChildren($children, $duration);
        $this->calculateTotalPrice();
        $this->formatStayPrice($this->stayPrice);
        $this->formatBreakfastPriceAdults($this->breakfastPriceAdult);
        $this->formatBreakfastPriceChildren($this->breakfastPriceChild);
        $this->formatTotalPrice($this->totalPrice);

        return [
            'stayPrice' => $this->stayPrice,
            'formattedStayPrice' => $this->formattedStayPrice,
            'breakfastPriceAdult' => $this->breakfastPriceAdult,
            'formattedBreakfastPriceAdult' => $this->formattedBreakfastPriceAdult,
            'breakfastPriceChild' => $this->breakfastPriceChild,
            'formattedBreakfastPriceChild' => $this->formattedBreakfastPriceChild,
            'totalPrice' => $this->totalPrice,
            'formattedTotalPrice' => $this->formattedTotalPrice
        ];
    }
}